package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class FunCallNode implements INode
{
    private String id;
    private ActualParamsNode actualArgs;
    private STentry entry;
    private int nestingLevel;

    public FunCallNode(String id, ActualParamsNode actualArgs, STentry entry)
    {
        this.id = id;
        this.actualArgs = actualArgs;
        this.entry = entry;
    }

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
