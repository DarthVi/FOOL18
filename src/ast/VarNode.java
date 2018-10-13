package ast;

import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.ClassType;
import type.IType;
import type.VoidType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements INode{

    //TODO: controllare che funzioni con le classi/oggetti e nel caso aggiornarla

    private String id;
    private IType type;
    private INode exp;
    private ParserRuleContext ctx;
    private STentry entry = null;
    private int currentNestingLevel;

    public VarNode(String id, INode exp, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = null;
        this.exp = exp;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(!exp.typeCheck().isSubtypeOf(type))
            throw new TypeException("assignment not allowed if rhs is not a subtype or the same tipe of lhs", ctx);

        //assignments are statements, which means they return void according to the specifications
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        StringBuilder getAR = new StringBuilder();
        for (int i = 0; i < currentNestingLevel - entry.getNestingLevel(); i++)
            getAR.append("lw\n");

        return exp.codeGeneration() +
                "push " + entry.getOffset() + "\n" + //metto offset sullo stack
                "lfp\n" + getAR + //risalgo la catena statica
                "add\n" +
                //carico sullo stack il valore all'indirizzo ottenuto
                "sw\n";
        //return exp.codeGeneration();
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> res = new ArrayList<>();
        Token token = ((FOOLParser.VarasmContext) ctx).ID().getSymbol();

        try
        {
            entry = env.getEntry(token);
            currentNestingLevel = env.getNestingLevel();
            //we need this in typeCheck() to check if the type return from the expression is compatible
            //with the type of the variable defined during declaration
            this.type = entry.getType();

            //if this node is an object variable and null is assigned to it,
            //we update the isNull flag in the symbol table and
            //set the classID of the NullNode
            if(this.type instanceof ClassType && exp instanceof NullNode)
            {
                env.updateIsNull(token.getText(), true);
                ((NullNode) exp).setClassID(((ClassType) this.type).getClassName());
            }
        }
        catch (UndeclaredVariableException e)
        {
            res.add(new SemanticError(e.getMessage()));
        }

        res.addAll(exp.checkSemantics(env));

        return res;
    }

    @Override
    public String toString()
    {
        return "Var: " + id + " -> " + type.toString() + "\n"
                + exp.toString();
    }
}
