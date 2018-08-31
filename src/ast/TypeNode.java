package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import util.SemanticError;
import util.Environment;
import type.*;

import java.util.ArrayList;

//TODO: controllare meglio questa classe
public class TypeNode implements INode {

    private String declaredType;
    private IType type;
    private Token token;

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
                this.token = ctx.getToken(FOOLParser.ID, 0).getSymbol();
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
        ArrayList<SemanticError> res = new ArrayList<>();

        //if we are referring to a class (for assignemnt, declarations, return type, etc.)
        //we must check if we have defined this class and produce an error otherwise.
        if(this.type instanceof ClassType)
        {
            try
            {
                this.type = env.getEntry(this.token).getType();
            } catch (UndeclaredVariableException e)
            {
                res.add(new SemanticError("Class '" + declaredType + "' does not exist"));
            }
        }

        return res;

    }

    @Override
    public String codeGeneration() {
        return "";
    }


    @Override
    public String toString() {
        return type.toString();
    }

    public IType getType()
    {
        return type;
    }
}
