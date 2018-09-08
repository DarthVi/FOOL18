package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ProgLetInNode implements INode
{
    private INode letPart;
    private INode dxPar;

    @Override
    public IType typeCheck() throws TypeException
    {
        //TODO
        return null;
    }

    @Override
    public String codeGeneration()
    {
        //TODO
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        //TODO
        return null;
    }
}
