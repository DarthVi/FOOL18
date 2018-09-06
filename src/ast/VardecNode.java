package ast;

import exception.TypeException;
import exception.VariableAlreadyDefinedException;
import parser.FOOLParser;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VardecNode implements INode
{
    private TypeNode type;
    private String id;
    private INode expression;
    private FOOLParser.VardecContext ctx;
    private boolean isAttribute;

    public VardecNode(TypeNode type, String id, INode expression, FOOLParser.VardecContext ctx, boolean isAttribute)
    {
        this.type = type;
        this.id = id;
        this.expression = expression;
        this.ctx = ctx;
        this.isAttribute = false;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        //We call typeCheck for the left-hand side (lhs) and right-hand side (rhs)
        try
        {
            IType sxType = type.typeCheck();
            IType dxType = null;

            //expression are not mandatory
            if (expression != null)
            {
                dxType = expression.typeCheck();

                if(!dxType.isSubtypeOf(sxType))
                    throw new TypeException("rhs value is not a subtype of the lhs declaration", ctx);
            }

            //declarations and assignment modify the environment but they only return void
            return new VoidType();

        }
        catch (TypeException e)
        {
            throw new TypeException("Error during assignment: " + e.getMessage(), ctx);
        }
    }

    @Override
    public String codeGeneration()
    {
        if(expression != null)
            return expression.codeGeneration();
        else
            return "push 0\n"; //TODO: check if it produces desired behaviour
    }

    /**
     * We call the checksemantics of the lvalue and rvalue (this one is optional, it may not be present in the
     * declaration). Then, if there are no errors, we add the entries in the symbol table.
     *
     * IMPORTANT!
     * Before calling this method, the caller MUST decide to add or not to add a new table to the symbol table.
     * Moreover it must initialize env.offset with the appropriate value.
     * @param env
     * @return
     */
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> res = new ArrayList<>();

        res.addAll(this.type.checkSemantics(env));

        //in declarations expressions are not mandatory in the grammar we have defined
        if(expression != null)
            res.addAll(this.expression.checkSemantics(env));

        //we try to add entries to the symbol table
        try
        {
            env.addEntry(ctx.ID().getSymbol(), type.getType(), env.offset, isAttribute);
        }
        catch (VariableAlreadyDefinedException e)
        {
            res.add(new SemanticError("Variable already defined: " + e.getMessage()));
        }

        return res;
    }

    @Override
    public String toString()
    {
        String expStr = (this.expression == null) ? "0" : this.expression.toString();
        return "Vardec: " + id + "\n"
                + type.toString()
                + expStr;
    }
}
