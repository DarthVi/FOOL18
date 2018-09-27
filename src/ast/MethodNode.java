package ast;

<<<<<<< HEAD
import org.antlr.v4.runtime.ParserRuleContext;
=======
import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.FunctionType;
>>>>>>> master
import type.IType;

import java.util.ArrayList;

public class MethodNode extends FunctionNode
{
<<<<<<< HEAD
    public MethodNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs, INode body, ParserRuleContext ctx)
=======
    public MethodNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs,
                      INode body, ParserRuleContext ctx)
>>>>>>> master
    {
        super(id, type, params, decs, body, ctx);
    }

<<<<<<< HEAD
=======
    public MethodNode(FunctionNode fn)
    {
        super(fn.id, fn.decReturnType, fn.params, fn.decs, fn.body, fn.ctx);
        this.fType = fn.fType;
    }

>>>>>>> master
    public String getId()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof MethodNode && this.id.equals(((MethodNode) (obj)).id));
    }

<<<<<<< HEAD
=======
    public IType getDeclaredReturnType()
    {
        return this.decReturnType;
    }


    public FunctionType getFunctionType()
    {
        ArrayList<IType> paramTypes = new ArrayList<>();

        for (FormalParamNode param : params)
        {
            paramTypes.add(param.getType());
        }

        return new FunctionType(decReturnType, paramTypes);
    }

    public ParserRuleContext getCtx()
    {
        return this.ctx;
    }


>>>>>>> master
    //TODO: see what's to override among codegen, checksemantics and typecheck
}
