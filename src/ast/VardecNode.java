package ast;

import exception.TypeException;
import exception.UndeclaredClassException;
import exception.VariableAlreadyDefinedException;
import parser.FOOLParser;
import type.ClassType;
import type.IType;
import type.VoidType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class VardecNode implements INode
{
    //TODO: controllare che funzioni con le classi/oggetti e nel caso aggiornarla

    private TypeNode type;
    private String id;
    private INode expression;
    private FOOLParser.VardecContext ctx;
    private boolean isAttribute;
    private Environment env;

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
                /*else
                {
                    //update environment information
                    STentry sTentry = env.getEntry(ctx.ID().getSymbol());
                    sTentry.setType(dxType);
                    env.addEntry(ctx.ID().getText(), sTentry);
                }*/
            }

            //declarations and assignment modify the environment but they only return void
            return new VoidType();

        }
        catch (TypeException e)
        {
            throw new TypeException("error during assignment; " + e.getMessage(), ctx);
        }
    }

    @Override
    public String codeGeneration()
    {
        if(expression != null)
            return expression.codeGeneration();
        else if (type.getType() instanceof ClassType && expression == null)
        {
            NullNode nullNode = new NullNode(ctx);
            nullNode.setClassID(((FOOLParser.VardecContext) ctx).type().ID().getText());
            return nullNode.codeGeneration();
        }
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
        boolean isNull = false;

        //in declarations expressions are not mandatory in the grammar we have defined
        if(expression != null)
            res.addAll(this.expression.checkSemantics(env));

        //we try to add entries to the symbol table
        try
        {
            IType assignedType = type.getType();

            if(type.getType() instanceof ClassType)
            {
                env.getClassType(ctx.type().ID().getSymbol());

                if(expression instanceof NullNode)
                {
                    isNull = true;
                    ((NullNode) expression).setClassID(((ClassType) this.type.getType()).getClassName());
                }
                /*else if(expression.typeCheck() instanceof ClassType)
                {
                    ClassType classt = (ClassType) expression.typeCheck();
                    ClassType classType = env.getClassType(classt.getClassName());
                    assignedType = classType;
                }*/
            }

            env.addEntry(ctx.ID().getSymbol(), assignedType, env.offset--, isAttribute);
            env.updateIsNull(ctx.ID().getText(), isNull);
        }
        catch (VariableAlreadyDefinedException |
                UndeclaredClassException e)
        {
            res.add(new SemanticError(e.getMessage()));
        }

        this.env = env;

        return res;
    }

    @Override
    public String toString()
    {
        String expStr = (this.expression == null) ? "0" : this.expression.toString();
        return "VarDec: " + id + " -> " + type.toString() + "\n"
                + expStr;
    }
}
