package ast;

import java.util.ArrayList;

import exception.TypeException;
import lib.FOOLlib;
import type.IType;
import util.Environment;
import util.SemanticError;


public class IfNode implements INode {

    private INode cond;
    private INode th;
    private INode el;

    public IfNode (INode c, INode t, INode e) {
        cond=c;
        th=t;
        el=e;
    }

    @Override
    public IType typeCheck() throws TypeException {
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return null;
    }

    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return cond.codeGeneration()+
                "push 1\n"+
                "beq "+ l1 +"\n"+
                el.codeGeneration()+
                "b " + l2 + "\n" +
                l1 + ":\n"+
                th.codeGeneration()+
                l2 + ":\n";
    }


}