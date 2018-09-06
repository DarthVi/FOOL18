package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.IType;
import type.VoidType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements INode{

    private String id;
    private IType type;
    private INode exp;
    private ParserRuleContext ctx;

    public VarNode(String id, IType type, INode exp, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.exp = exp;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(!exp.typeCheck().isSubtypeOf(type))
            throw new TypeException("Type error: assignment not allowed if rhs is not a subtype or the same tipe of lhs", ctx);

        //assignments are statements, which means they return void according to the specifications
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        //TODO
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> res = new ArrayList<>();
        STentry entry = null;
        Token token = ((FOOLParser.VarasmContext) ctx).ID().getSymbol();

        try
        {
            entry = env.getEntry(token);
            //we need this in typeCheck() to check if the type return from the expression is compatible
            //with the type of the variable defined during declaration
            this.type = entry.getType();
        }
        catch (UndeclaredVariableException e)
        {
            res.add(new SemanticError("Error: undeclared variable"));
        }

        return res;
    }

    @Override
    public String toString()
    {
        return "Var: " + id + "\n"
                + type.toString()
                + exp.toString();
    }
}
