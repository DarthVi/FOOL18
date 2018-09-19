package ast;

import exception.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.*;
import util.Environment;
import util.SemanticError;
import vm.VTableEntry;

import java.util.ArrayList;

public class ClassDecNode implements INode
{
    private ClassType classType;
    private ParserRuleContext ctx;
    //private VTableEntry virtualFunctionTable;

    public ClassDecNode(ClassType classType, ParserRuleContext ctx)
    {
        this.classType = classType;
        this.ctx = ctx;
    }


    //TODO: completare questo codice

    @Override
    public IType typeCheck() throws TypeException
    {
        try
        {
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

        try
        {
            if(classType.getParent() == null)
                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(), classType);
            else
            {
                ClassType parentType = env.getClassType(((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol());

                //checking that we are not overriding members
                for(FOOLParser.ArgdecContext ac : ((FOOLParser.ClassdecContext) (ctx)).argdec())
                {
                    String varName = ac.ID().getText();

                    if(classType.getClassMembers().containsKey(varName))
                        throw new ClassMemberOverridingException(ac.ID().getSymbol());

                }

                env.addClassType(((FOOLParser.ClassdecContext) (ctx)).ID(0).getSymbol(),
                        ((FOOLParser.ClassdecContext) (ctx)).ID(1).getSymbol(),
                        classType);

            }
        }catch (ClassAlreadyDefinedException
                | UndeclaredClassException
                | ClassMemberOverridingException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }


        return null;
    }
}
