package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdNode implements INode {

    public IType typeCheck() throws TypeException {
        return null;
    }

    public String codeGeneration(){
        return null;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env){
        return null;
    }

    @Override
    public String toString(){
        return null;
    }

}