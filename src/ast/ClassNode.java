package ast;

import exception.TypeException;
import type.ClassType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ClassNode implements INode
{
    private ClassType classType;


    //TODO: completare questo codice

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
}
