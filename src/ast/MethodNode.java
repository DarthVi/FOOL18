package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.ClassType;
import type.FunctionType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class MethodNode extends FunctionNode
{
    //index to the dispatch function table in which this method is located
    private ClassType classType;

    public MethodNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs,
                      INode body, ParserRuleContext ctx)
    {
        super(id, type, params, decs, body, ctx);
    }

    public MethodNode(FunctionNode fn)
    {
        super(fn.id, fn.decReturnType, fn.params, fn.decs, fn.body, fn.ctx);
        this.fType = fn.fType;
    }

    public String getId()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof MethodNode && this.id.equals(((MethodNode) (obj)).id));
    }

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

    public ClassType getClassType()
    {
        return classType;
    }

    public void setClassType(ClassType classType)
    {
        this.classType = classType;
    }


    @Override
    public String codeGeneration() {
        StringBuilder declCode = new StringBuilder();
        if (decs != null)
            for (INode dec : decs)
                declCode.append(dec.codeGeneration());

        StringBuilder popDecl = new StringBuilder();
        if (decs != null)
            for (INode dec : decs)
                popDecl.append("pop\n");

        StringBuilder popParl = new StringBuilder();
        for (INode dec : params)
            popParl.append("pop\n");

        String funl = FOOLlib.freshFunLabel();
        FOOLlib.insertfun(funl
                + ":\n"
                + "cfp\n"                   //setta $fp a $sp
                + "lra\n"                   //inserimento return address
                + declCode                  //inserimento dichiarazioni locali
                + body.codeGeneration()
                + "srv\n"                   //pop del return value
                + popDecl
                + "sra\n"                   // pop del return address
                + "pop\n"                   // pop di AL
                + popParl
                + "sfp\n"                   // setto $fp a valore del CL
                + "lrv\n"                   // risultato della funzione sullo stack
                + "lra\n"
                +"js\n"                      // salta a $ra
        );

        return funl + "\n";
    }


    //TODO: see what's to override among  checksemantics and typecheck
}
