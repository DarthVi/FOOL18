package ast;

import exception.TypeException;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ProgLetInNode implements INode
{
    //LetNode, which contains declarations
    private INode letPart;
    //this could be exp or stats according to the grammar
    private INode dxPar;

    @Override
    public IType typeCheck() throws TypeException
    {
        letPart.typeCheck();

        return dxPar.typeCheck();
    }

    @Override
    public String codeGeneration()
    {
        String code;

        code = letPart.codeGeneration() + dxPar.codeGeneration() + "halt\n";

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
        errors.addAll(dxPar.checkSemantics(env));

        //exiting the scope
        env.removeLastHashMap();

        return errors;
    }
}
