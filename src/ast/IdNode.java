package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class IdNode implements INode
{
    //TODO: completare questa classe

    private String varName;
    private STentry entry;
    private int nestingLevel;

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
    public String toString(){
        return null;
    }


    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return null;
    }
}