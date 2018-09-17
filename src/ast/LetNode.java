package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class LetNode implements INode{

    private ArrayList<INode> declist;
    private ParserRuleContext ctx;

    public LetNode(ArrayList<INode> declist, ParserRuleContext ctx)
    {
        this.declist = declist;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        for(INode declaration : declist)
        {
            declaration.typeCheck();
        }

        //let <declarations> returns void because each declaration returns void as decided during language design
        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        String declCode = "";
        for (INode dec : declist)
            declCode += dec.codeGeneration();
	//TODO: LorenzoMass, controlla che sia corretto
	//ho tolto exp, dovremmo gestirle lato vardec e varasm
        return "push 0\n" +
                declCode +
                "halt\n"; // goes at the end of ProgLetIn, after the "in part" (body) codegen, the end of the program
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        for(INode dec : declist)
            errors.addAll(dec.checkSemantics(env));

        return errors;
    }
}
