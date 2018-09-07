package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ArgumentsNode implements INode
{
    //TODO


    @Override
    public IType typeCheck() throws TypeException
    {
        return null;
    }

    @Override
    public String codeGeneration()
    {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return null;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
