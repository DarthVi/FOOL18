package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class PlusNode implements INode {

    private INode left;
    private INode right;

    public PlusNode (INode l, INode r) {
        left=l;
        right=r;
    }


    @Override
    public IType typeCheck() throws TypeException {
        return null; //TO DO
    }


    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null; //TO DO
    }

    @Override
    public String codeGeneration() {
        return left.codeGeneration() +
                right.codeGeneration() +
                "add\n";
    }

}

