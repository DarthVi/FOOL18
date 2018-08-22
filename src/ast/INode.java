package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public interface INode
{
    INode typeCheck();

    String codeGeneration();

    ArrayList<SemanticError> checkSemantics(Environment env);

    String toPrint(String str);
}
