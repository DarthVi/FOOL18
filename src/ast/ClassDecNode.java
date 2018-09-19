package ast;

import exception.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.*;
import util.Environment;
import util.SemanticError;
import vm.VTableEntry;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassDecNode implements INode
{
    private ClassType classType;
    private ParserRuleContext ctx;
    //members declared in this class
    private ArrayList<MemberNode> members;
    private ArrayList<FunctionNode> methods;
    //members declared in this class + its parent
    private ArrayList<MemberNode> allMembers;
    //private VTableEntry virtualFunctionTable;

    public ClassDecNode(ClassType classType, ArrayList<MemberNode> members,
                        ArrayList<FunctionNode> methods, ParserRuleContext ctx)
    {
        this.classType = classType;
        this.members = members;
        this.methods = methods;
        this.ctx = ctx;
        this.allMembers = new ArrayList<>();
    }


    @Override
    public IType typeCheck() throws TypeException
    {
        try
        {
            //TODO: should we go up the parent chain here? before solving this
            //TODO: try to understand what to to with the virtual function table/dispatch table
            if (classType.getParent() != null)
            {
                ClassType parentType = classType.getParent();

                //checking if methods are overridden correctly
                for (FOOLParser.FunContext fc : ((FOOLParser.ClassdecContext) (ctx)).fun())
                {
                    String methodName = fc.ID().getText();

                    if (parentType.getClassMethods().containsKey(methodName))
                    {
                        ClassMethod childMethod = (ClassMethod) classType.getClassMethods().get(methodName);

                        ClassMethod parentMethod = (ClassMethod) parentType.getClassMethods().get(methodName);

                        //if a method has the same name of a parent's method and it does not override it
                        //correctly, then throw an exception
                        if (!childMethod.getMethodType().isOverloading(parentMethod.getMethodType()))
                            throw new OverrideErrorException(fc.ID().getSymbol());
                    }
                }
            }
        }
        catch(OverrideErrorException e)
        {
            throw new TypeException(e.getMessage(), ctx);
        }

        return this.classType;
    }

    @Override
    public String codeGeneration()
    {
        //TODO completare questo metodo
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        ArrayList<MemberNode> allMembers = new ArrayList<>();

        try
        {
            if(classType.getParent() == null)
                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(), classType);
            else
            {
                //we check if the declared parent exists, otherwise the method throws an exception
                ClassType parentType = env.getClassType(((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol());

                //we set the current parent
                ClassType currentParent = classType.getParent();

                //we must retrieve the parent members going up through the parent chain
                while(currentParent != null)
                {
                    if (!currentParent.getClassMembers().values().isEmpty())
                    {
                        for (Object o : classType.getParent().getClassMembers().values())
                        {
                            ClassMember cm = (ClassMember) o;

                            MemberNode memberNode = new MemberNode(cm.getMemberID(), cm.getType(),  (FOOLParser.ArgdecContext) cm.getCtx());

                            allMembers.add(memberNode);
                        }
                    }

                    currentParent = currentParent.getParent();
                }

                //checking that we are not overriding members, if not we add them to the member list
                //containing ALL the members
                for(MemberNode memberNode : members)
                {
                    String varName = memberNode.getId();

                    if(classType.getClassMembers().containsKey(varName))
                        throw new ClassMemberOverridingException(memberNode.getCtx().ID().getSymbol());

                    allMembers.add(memberNode);


                }

                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(),
                        ((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol(),
                        classType);

                this.allMembers = allMembers;

                //adding a new scope

                env.addHashMap();
                //calling the checkSemantics on members: we need this to populate the symbol table and allow
                //class methods to see the class members
                for(MemberNode md : this.allMembers)
                    errors.addAll(md.checkSemantics(env));

                //calling the checkSemantics on methods
                for(FunctionNode fn : methods)
                    errors.addAll(fn.checkSemantics(env));

                //exiting the scope
                env.removeLastHashMap();

                //TODO: virtual function table

            }
        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
                | ClassMemberOverridingException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }


        return errors;
    }

    @Override
    public String toString()
    {
        return "ClassDecNode: " + classType.toString();
    }
}
