package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.runtime.CommonToken;
import util.SemanticError;
import util.Environment;
import type.*;

import java.util.ArrayList;

//TODO: controllare meglio questa classe
public class TypeNode implements INode {

    private String declaredType;
    private IType type;

    public TypeNode(antlr.FOOLParser.TypeContext ctx, String type) {
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
    public IType typeCheck() throws TypeException
    {
        return type;
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
        //TODO: fixare questo metodo dopo aver capito come minchia gestire le classi
        return new ArrayList<SemanticError>();

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
