package ast;

import exception.TypeException;
import exception.VariableAlreadyDefinedException;
import lib.FOOLlib;
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
    protected boolean isAttribute;
    protected ParserRuleContext ctx;
    protected boolean isClass;

    public FormalParamNode(String id, IType type, boolean isAttribute, boolean isClass, ParserRuleContext ctx)
    {
        this.id = id;
        this.type = type;
        this.isAttribute = isAttribute;
        this.isClass = isClass;
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

        System.out.println(FOOLlib.getNumberDeclarations());
        if(isClass) {
            try {
                env.addEntry(((FOOLParser.ArgdecContext) ctx).ID().getSymbol(), type, 2+FOOLlib.getNumberDeclarations(), false);
            } catch (VariableAlreadyDefinedException e) {
                res.add(new SemanticError(e.getMessage()));
            }
        }

        else if(!isAttribute) {
            try {
                env.addEntry(((FOOLParser.ArgdecContext) ctx).ID().getSymbol(), type, env.offset--, isAttribute);
            } catch (VariableAlreadyDefinedException e) {
                res.add(new SemanticError(e.getMessage()));
            }
        }

        else {
            try {
                env.addEntry(((FOOLParser.ArgdecContext) ctx).ID().getSymbol(), type, env.offset++, isAttribute);
            } catch (VariableAlreadyDefinedException e) {
                res.add(new SemanticError(e.getMessage()));
            }
        }

        return res;
    }

    public IType getType()
    {
        return this.type;
    }

    @Override
    public String toString()
    {
        return "Function parameter " + type + " " + id;
    }
}
