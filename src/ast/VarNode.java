package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.VoidType;
import util.Environment;
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
        /*
         * TODO: vedere se abbiamo l'id nella tabella dei simboli, ma oltre a ritornare la lista di errori
         * (eventualmente vuota qualora non ce ne siano), va aggiornato anche this.type, in modo da poter far
         * partire successivamente il typechecking. Non possiamo dedurre il tipo dalla sintassi visto che questo nodo
         * può essere anche generato tramite istruzioni di assegnamento
         */
        return null;
    }

    @Override
    public String toString()
    {
        return "Var: " + id + "\n"
                + type.toString()
                + exp.toString();
    }
}
