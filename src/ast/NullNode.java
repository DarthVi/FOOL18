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
        //TODO: is -1 a good value for null? Supposedly yes, we cannot have negative addresses for objects, but
        //we can have objects stored in the memory starting from address 0
        return "push -1";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return new ArrayList<SemanticError>();
    }
}
