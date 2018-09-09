package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunctionNode implements INode
{

    private String id;
    private IType decReturnType;
    private ArrayList<FormalParamNode> params;
    private ArrayList<INode> decs;
    private INode body;
    private ParserRuleContext ctx;

    public FunctionNode(String id, IType type, ArrayList<FormalParamNode> params, ArrayList<INode> decs, INode body, ParserRuleContext ctx)
    {
        this.id = id;
        this.decReturnType = type;
        this.params = params;
        this.decs = decs;
        this.body = body;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(!decs.isEmpty())
        {
            for(INode dec : decs)
            {
                dec.typeCheck(); //no need to try..catch this, we are in a function that throws TypeException
            }
        }

        IType bodyReturnType = body.typeCheck();

        if(!bodyReturnType.isSubtypeOf(decReturnType))
        {
            throw new TypeException("Body return type is incompatible with declared return type.", ctx);
        }

        //we need this to build the FunctionType class
        ArrayList<IType> paramTypes = new ArrayList<>();

        for (FormalParamNode param : params)
        {
            paramTypes.add(param.typeCheck());
        }

        return new FunctionType(decReturnType, paramTypes);

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

        //let's add symbol table entry for the function ID
        //TODO: check if this offset is ok
        env.addEntry(((FOOLParser.FunContext) ctx).ID().getSymbol(), funType, env.offset, false);

        env.addHashMap();
        env.offset = -2;

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

        // TODO controllare che funzioni per classi e oggetti
        return errors;
    }
}
