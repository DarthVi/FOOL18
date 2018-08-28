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
        //TODO: shouldn't we consider a machine code value for null?
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return new ArrayList<SemanticError>();
    }
}
