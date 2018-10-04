package ast;

import exception.InvalidObjectInstantiation;
import exception.TypeException;
import exception.UndeclaredClassException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.ClassMember;
import type.ClassType;
import type.IType;
import util.DTableEntry;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewNode implements INode
{
    private String className;
    private ClassType classType;
    private ActualParamsNode actualArgs;
    private ParserRuleContext ctx;
    public ArrayList<DTableEntry> dTable;

    public NewNode(String className, ActualParamsNode actualArgs, ParserRuleContext ctx)
    {
        this.className = className;
        this.actualArgs = actualArgs;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        actualArgs.typeCheck();

        ArrayList<ClassMember> cmList = classType.getDeclaredOrderMembers();

        //we must check that the actual arguments are of the right type
        //(they must match class members type)
        for(int i = 0; i < actualArgs.size(); i++)
        {
            INode arg = actualArgs.get(i);

            if(!arg.typeCheck().isSubtypeOf(cmList.get(i).getType()))
                throw new TypeException("Argument " + (i + 1) + " has an incorrect type.",ctx);
        }

        //TODO: check if we need to introduce a new type, like InstanceType
        return this.classType;

    }

    @Override
    public String codeGeneration()
    {
        StringBuilder code = new StringBuilder(actualArgs.codeGeneration());

        code.append("push ").append(actualArgs.size()).append("\n")
                .append("push class").append(className).append("\n")
                .append("new\n");

        return code.toString();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        //lets check if the class we want to instantiate exists
        try
        {
            this.classType = env.getClassType(
                    ((FOOLParser.ObjInstContext) ctx).ID().getSymbol());
        }catch(UndeclaredClassException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }

        //we must have the same actual arguments defined in the constructor
        try {
            if (actualArgs.size() != classType.getClassMembers().size()){
                throw new InvalidObjectInstantiation(className);
            } else {
                //calling argument's checkSemantics
                errors.addAll(actualArgs.checkSemantics(env));
            }
        } catch (InvalidObjectInstantiation e){
            errors.add(new SemanticError(e.getMessage()));
        }

        this.dTable = env.getDftTable(this.className);

        return errors;
    }
}
