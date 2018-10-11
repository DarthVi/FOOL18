package ast;

import exception.TypeException;
import exception.VariableAlreadyDefinedException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.ClassType;
import type.FunctionType;
import type.IType;
import util.Environment;
import util.STentry;
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
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();


        FunctionType funType = null;

        ArrayList<IType> paramTypes = new ArrayList<>();

        //this is needed to build the symbol table entry for the function ID
        try
        {
            for (FormalParamNode param : params)
            {
                paramTypes.add(param.typeCheck());
            }
        }
        catch (TypeException e)
        {
            //do nothing
            //it's never going to happen, see FormalParamNode.typeCheck()
        }

        funType = new FunctionType(decReturnType, paramTypes);

        this.fType = funType;

        env.addHashMap();

        int savedOffset = env.offset;  //salvato offset della dichiarazione di funzione, per ripristinarlo dopo
        env.offset = 1;                //l'offset dei parametri formali inizia da 1.

        try
        {
            env.addEntry("this", this.classType, 0, true);
        }
        catch (VariableAlreadyDefinedException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }

        // Parametri formali
        for (FormalParamNode param : params) {
            errors.addAll(param.checkSemantics(env));
        }

        env.offset=-2;                 // offset delle dichiarazioni locali


        // Variabili locali
        for (INode dec : decs){
            errors.addAll(dec.checkSemantics(env));
        }
        // Body della funzione
        errors.addAll(body.checkSemantics(env));
        env.removeLastHashMap();

        //TODO: check if we need to reset the offset of the environment

        env.offset = savedOffset-1;

        // TODO controllare che funzioni per classi e oggetti
        return errors;

    }

    public String codeGeneration(String functionLabel) {
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

        String funl = FOOLlib.freshmethodLabel();
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

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }


    //TODO: see what's to override among  checksemantics and typecheck
}
