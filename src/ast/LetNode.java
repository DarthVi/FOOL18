package ast;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.Iterator;

public class LetNode implements INode{

    private ArrayList<INode> declist;
    private ParserRuleContext ctx;
    private INode exp;

    public LetNode(ArrayList<INode> declist, ParserRuleContext ctx, INode exp)
    {
        this.declist = declist;
        this.ctx = ctx;
        this.exp = exp;
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
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return null;
    }


    @Override
    public String codeGeneration() {
        String declCode = "";
        for (INode dec : declist)
            declCode += dec.codeGeneration();
        return "push 0\n" +
                declCode +
                exp.codeGeneration() + "halt\n";
    }

}