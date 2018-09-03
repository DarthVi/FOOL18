package ast;

import exception.TypeException;
import type.IType;
import type.NullType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NullNode implements INode
{
    @Override
    public String toString()
    {
        return "null";
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return new NullType();
    }

    @Override
    public String codeGeneration()
    {
        //TODO: is 0 a good value for null?
        return "push 0";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return new ArrayList<SemanticError>();
    }
}
