package ast;

import java.util.ArrayList;
import util.Environment;
import util.SemanticError;

public class MinusNode implements INode {

    private INode left;
    private INode right;

    public MinusNode (INode l, INode r) {
        left=l;
        right=r;
    }

    @Override
    public String codeGeneration() {
        return left.codeGeneration() +
                right.codeGeneration() +
                "sub\n";
    }


}