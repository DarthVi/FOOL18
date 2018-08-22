package ast;

import exception.TypeException;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VoidNode implements INode
{
    @Override
    public String toString()
    {
        return "void";
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        //TODO: shouldn't we consider a machine code value for void?
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return new ArrayList<SemanticError>();
    }
}
