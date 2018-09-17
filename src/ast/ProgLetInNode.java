package ast;

import exception.TypeException;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ProgLetInNode implements INode
{
    //LetNode, which contains declarations
    private INode letPart;
    //according to the grammar we can either have exp or stast
    private INode exp;
    private ArrayList<INode> stats;

    public ProgLetInNode(INode letPart, INode exp, ArrayList<INode> stats)
    {
        this.letPart = letPart;
        this.exp = exp;
        this.stats = stats;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
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
        String code = letPart.codeGeneration();

        if(exp != null)
            code += exp.codeGeneration() + "halt\n";
        else
        {
            StringBuilder statsCode = new StringBuilder();

            for(INode stat : stats)
            {
                statsCode.append(stat.codeGeneration());
            }

            code += statsCode.toString() + "halt\n";
        }

        return code;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        //let's add a new scope
        env.addHashMap();
        env.offset = -2;

        //semantic check for the let part
        errors.addAll(((LetNode) letPart).checkSemantics(env));
        //semantic check for the body (exp or stats)

        if(exp != null)
            errors.addAll(exp.checkSemantics(env));
        {
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
        String string = "ProgLetInNode\n" +
                letPart.toString() + "\n";
        if (exp != null){
            string += exp.toString();
        }
        for(INode stat : stats) {
            string += stat.toString();
        }
        return string;
    }
}
