package ast;

import exception.TypeException;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * It holds info about the actual arguments used when calling a function (see {@link FunCallNode})
 * or when creating a new object instance (see {@link NewNode}).
 * The types of the actual arguments must be compared to the types of the formal parameters (see
 * {@link FunctionNode} and {@link FormalParamNode}) in order to check if the call obeys
 * the chosen type system.
 */
public class ActualParamsNode implements INode
{
    private ArrayList<INode>  actualArguments;

    public ActualParamsNode(ArrayList<INode> actualArguments)
    {
        this.actualArguments = actualArguments;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        //effective arguments may also be the results of different kinds of expressions, not only variables
        //which means we must type check them
        for(INode arg : actualArguments)
            arg.typeCheck();

        //there isn't a unique return type for a list of actual parameters and we also don't need it
        //this is just a placeholder
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        //StringBuilder used for efficiency purposes, in order to avoid making a copy
        //of the string and reassigning a new string in each step of the next loop (strings are immutable)
        StringBuilder code = new StringBuilder();

        //this would be equivalent to code += arg.codeGeneretion() if strings were used instead of StringBuilder
        for(INode arg: actualArguments)
            code.append(arg.codeGeneration());

        return code.toString();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        for(INode arg : actualArguments)
            errors.addAll(arg.checkSemantics(env));

        return errors;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append("Actual arguments: ");

        for(INode arg : actualArguments)
            str.append(arg.toString()).append("; ");

        return str.toString();
    }

    public int size() {return actualArguments.size(); }

    public INode get(int index) {
        return actualArguments.get(index);
    }
}
