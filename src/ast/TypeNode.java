package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import parser.FOOLParser;
import util.SemanticError;
import util.Environment;
import type.*;

import java.util.ArrayList;

//TODO: controllare meglio questa classe
public class TypeNode implements INode {

    String declaredType;
    IType type;

    public TypeNode(FOOLParser.TypeContext ctx, String type) {
        declaredType = type;
        switch (type) {
            case "int":
                this.type = new IntType();
                break;
            case "bool":
                this.type = new BoolType();
                break;
            case "void":
                this.type = new VoidType();
            default:
                this.type = new ClassType(ctx.getText());
                break;
        }
    }

    @Override
    public INode typeCheck()
    {
        //TODO: fixare questo metodo
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
//        ArrayList<SemanticError> res = new ArrayList<>();
//        try {
//            this.type = env.getLatestEntryOf(declaredType).getType();
//        } catch (UndeclaredVarException e) {
//            res.add(new SemanticError("Class '" + declaredType + "' does not exist"));
//        }
//        return res;
        //TODO: fixare questo metodo
        return null;
    }

    @Override
    public String codeGeneration() {
        return "";
    }


    @Override
    public String toString() {
        return type.toString();
    }

}
