package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements INode
{

    private String id;
    private IType type;
    private ArrayList<FormalParamNode> params = new ArrayList<FormalParamNode>();
    private ArrayList<INode> decs;
    private INode body;
    private ParserRuleContext ctx;

    public FunctionNode(String id, IType type, ArrayList<INode> decs, INode body, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.decs = decs;
        this.body = body;
        this.ctx = ctx;
    }

    public FunctionNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs, INode body, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.params = params;
        this.decs = decs;
        this.body = body;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return null;
    }

    @Override
    public String codeGeneration()
    {
        StringBuilder decsCode = new StringBuilder();
        StringBuilder decsPop = new StringBuilder();
        if (decs != null) {
            for (INode dec : decs) {
                decsCode.append(dec.codeGeneration());
                decsPop.append("pop\n");
            }
        }

        StringBuilder paramsPop = new StringBuilder();
        if (params != null) {
            for (INode par : params)
                paramsPop.append("pop\n");
        }

        return "push\n" +
                FOOLlib.freshFunLabel() + "\n" +
                "cfp\n" + //setta $fp a $sp
                "lra\n" + //inserimento return address
                decsCode + //inserimento dichiarazioni locali
                body.codeGeneration() +
                "srv\n" + //pop del return value
                decsPop +
                "sra\n" + // pop del return address
                "pop\n" + // pop di AL
                paramsPop +
                "sfp\n" +  // setto $fp a valore del CL
                "lrv\n" + // risultato della funzione sullo stack
                "lra\n" + "js\n";  // salta a $ra
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();
        env.addHashMap();
        // Parametri formali
        for (FormalParamNode param : params) {
            errors.addAll(param.checkSemantics(env));
        }
        // Variabili locali
        for (INode dec : decs){
            errors.addAll(dec.checkSemantics(env));
        }
        // Body della funzione
        errors.addAll(body.checkSemantics(env));
        env.removeLastHashMap();
        // TODO da completare
        return errors;
    }
}
