package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public interface INode
{
    IType typeCheck() throws TypeException;

    String codeGeneration();

    ArrayList<SemanticError> checkSemantics(Environment env);

    @Override
    String toString();
}
