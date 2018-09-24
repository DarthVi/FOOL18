package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class SingleExp implements INode {
    INode exp;

    public SingleExp(INode exp) {
        this.exp = exp;
    }

    @Override
    public IType typeCheck() throws TypeException {
        return exp.typeCheck();
    }

    @Override
    public String codeGeneration() {
        return exp.codeGeneration()
                + "halt\n" ;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(exp.checkSemantics(env));
        return errors;
    }

}
