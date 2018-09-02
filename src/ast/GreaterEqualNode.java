package ast;

import exception.TypeException;
import lib.FOOLlib;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class GreaterEqualNode implements INode {

    private INode left;
    private INode right;

    public GreaterEqualNode(INode left, INode right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public IType typeCheck() throws TypeException {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }

    @Override
    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();

        return right.codeGeneration() +
                left.codeGeneration() +
                "bleq " + l1 + "\n" +
                "push 0\n" +
                "b " + l2 + "\n" +
                l1 + ":\n" +
                "push 1\n" +
                l2 + ":\n";
    }

}
