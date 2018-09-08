package ast;

import exception.TypeException;
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
        return null;
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
