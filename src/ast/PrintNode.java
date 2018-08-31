package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

public class PrintNode implements INode {

    private INode val;

    public PrintNode (INode v) {
        val=v;
    }

    @Override
    public String codeGeneration() {
        return "print " + val + "\n";
    }
}