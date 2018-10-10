package ast;

import exception.*;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.*;
import util.Environment;
import util.SemanticError;
import util.DTableEntry;

import java.util.*;
import java.util.stream.Collectors;

public class ClassDecNode implements INode
{
    private ClassType classType;
    private String parentStr;
    private ParserRuleContext ctx;
    //members declared in this class
    private ArrayList<MemberNode> members;
    private ArrayList<MethodNode> methods;
    //private DTableEntry virtualFunctionTable;
    HashMap<String, String> fromIdtoLabelFunc = new HashMap<>();



    public ClassDecNode(ClassType classType, String parentStr, ArrayList<MemberNode> members,
                        ArrayList<MethodNode> methods, ParserRuleContext ctx)
    {
        this.classType = classType;
        this.parentStr = parentStr;
        this.members = members;
        this.methods = methods;
        this.ctx = ctx;
    }

    public HashMap<String, String> getFromIdtoLabelFunc()
    {
        return fromIdtoLabelFunc;
    }

    public void setFromIdtoLabelFunc(HashMap<String, String> fromIdtoLabelFunc)
    {
        this.fromIdtoLabelFunc = fromIdtoLabelFunc;
    }

    public ClassType getClassType()
    {
        return classType;
    }

    public void setClassType(ClassType classType)
    {
        this.classType = classType;
    }

    public ArrayList<MemberNode> getMembers()
    {
        return members;
    }

    public void setMembers(ArrayList<MemberNode> members)
    {
        this.members = members;
    }

    public ArrayList<MethodNode> getMethods()
    {
        return methods;
    }

    public void setMethods(ArrayList<MethodNode> methods)
    {
        this.methods = methods;
    }

    public String getParentStr()
    {
        return parentStr;
    }

    public void setParentStr(String parentStr)
    {
        this.parentStr = parentStr;
    }

    public ParserRuleContext getCtx()
    {
        return ctx;
    }

    public void setCtx(ParserRuleContext ctx)
    {
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        try
        {
            ClassType currentParent = classType.getParent();

            //we check if overrides are correct through the whole parent chain
            //Example to explain why this is necessary:
            //we have 3 classes, a "grandparent" a "parent" and a "child"; the child
            //may override none of the parent's methods but some of the granparent's ones.
            if(currentParent != null)
            {

                //checking if methods are overridden correctly.

                //we use the context to iterate because we need the token info to display
                //the errors (if any) appropriately (with info about lines and columns). Otherwise
                //we could have used ClassMethod got from classType right here
                for (FOOLParser.FunContext fc : ((FOOLParser.ClassdecContext) (ctx)).fun())
                {
                    String methodName = fc.ID().getText();

                    if (currentParent.getClassMethods().containsKey(methodName))
                    {
                        ClassMethod childMethod = (ClassMethod) classType.getClassMethods().get(methodName);

                        ClassMethod parentMethod = (ClassMethod) currentParent.getClassMethods().get(methodName);

                        //if a method has the same name of a parent's method and it does not override it
                        //correctly, then throw an exception
                        if (!childMethod.getMethodType().isOverriding(parentMethod.getMethodType()))
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
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();


        try
        {
            //adding a new scope
            env.addHashMap();
            //calling the checkSemantics on members: we need this to populate the symbol table and allow
            //class methods to see the class members

            env.offset=1;
            for(MemberNode md : this.members) {
                errors.addAll(md.checkSemantics(env));
            }

            //In order to be able tu use mutual recursion,
            //we must add all the methods to the symbol table before calling each method's
            //checkSemantics
            for(MethodNode fn : methods)
            {
                //setting the ClassType we must refer to for this MethodNode.
                //This way we can use this information inside MethodNode when needed.
                fn.setClassType(this.classType);
                FunctionType fnType = fn.getFunctionType();

                //lets add here the signature of the function to the symbol table,
                //in order to support mutual recursion

                env.addEntry(((FOOLParser.FunContext) (fn.getCtx())).ID().getSymbol(),
                        fnType, env.offset++, true);
            }

            //calling the checkSemantics on methods
            for(MethodNode fn: methods)
                errors.addAll(fn.checkSemantics(env));

            //exiting the scope
            env.removeLastHashMap();

        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
                | ClassMemberOverridingException
                | MethodAlreadyDefinedException
                | MissingMemberException
                | IncorrectOrderConstructorException e)
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

    @Override
    public String codeGeneration()
    {
        //generazione del codice dei metodi, passato come parametro la label della funzione
        for (MethodNode m:methods) {
            m.codeGeneration(fromIdtoLabelFunc.get(m.getId()));
        }

        //TODO completare questo metodo
        //dovrebbe bastare, perchè la creazione della DispatchTableEntry viene fatta nelle funzioni sopra
        return "";
    }

    public String getClassID() {
        return classType.toString();
    }

    public String getSuperClassID() {
        return this.parentStr;
    }



}
