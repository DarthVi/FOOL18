package ast;

import exception.TypeException;
import exception.VariableAlreadyDefinedException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * Used for storing info about formal parameters. It will be used inside {@link FunctionNode} to store
 * the necessary info on the symbol table in order to be able to call the function. When function call happens,
 * we must be able to check if all of the {@link ActualParamsNode} are compatible with the formal parameters.
 */
public class FormalParamNode implements INode
{
    protected String id;
    protected IType type;
    private int offset;
    private boolean isAttribute;
    protected ParserRuleContext ctx;

    public FormalParamNode(String id, IType type, int offset, boolean isAttribute, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.offset = offset;
        this.isAttribute = isAttribute;
        this.ctx = ctx;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return type;
    }

    @Override
    public String codeGeneration()
    {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> res = new ArrayList<>();

        try
        {
            env.addEntry(((FOOLParser.ArgdecContext) ctx).ID().getSymbol(), type, offset, isAttribute );
        }
        catch (VariableAlreadyDefinedException e)
        {
            res.add(new SemanticError(e.getMessage()));
        }

        return res;
    }

    @Override
    public String toString()
    {
        return "Function parameter " + type + " " + id;
    }
}
