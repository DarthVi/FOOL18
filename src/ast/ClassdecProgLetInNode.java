package ast;

import exception.TypeException;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ClassdecProgLetInNode implements INode
{
    //list containing class declarations
    private ArrayList<ClassDecNode> classdecs;
    //LetNode, which contains declarations
    private INode letPart;
    //according to the grammar we can either have exp or stast
    private INode exp;
    private ArrayList<INode> stats;

    public ClassdecProgLetInNode(ArrayList<ClassDecNode> classdecs, INode letPart, INode exp, ArrayList<INode> stats)
    {
        this.classdecs = classdecs;
        this.letPart = letPart;
        this.exp = exp;
        this.stats = stats;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public IType typeCheck() throws TypeException
    {
        //typecheck for each class declaration
        for(ClassDecNode cn : classdecs)
            cn.typeCheck();

        letPart.typeCheck();

        if(exp != null)
            return exp.typeCheck();
        else
        {
            for(INode stat : stats)
            {
                stat.typeCheck();
            }

            return new VoidType();
        }
    }

    @Override
    public String codeGeneration()
    {
        //TODO
        return null;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        //semantic check for each class declaration
        for(ClassDecNode cn : classdecs)
            errors.addAll(cn.checkSemantics(env));

        //let's add a new scope
        env.addHashMap();
        env.offset = -2;

        //semantic check for the let part
        errors.addAll(((LetNode) letPart).checkSemantics(env));
        //semantic check for the body (exp or stats)

        if(exp != null)
            errors.addAll(exp.checkSemantics(env));
        else {
            for(INode stat : stats)
                errors.addAll(stat.checkSemantics(env));
        }

        //exiting the scope
        env.removeLastHashMap();

        return errors;
    }

    @Override
    public String toString()
    {
        //TODO
        return super.toString();
    }
}