package ast;

import exception.FunctionAlreadyDefinedException;
import parser.FOOLBaseVisitor;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
import util.Environment;

import java.util.ArrayList;

/**
 * We need a first pass to get all the function declarations in order to be able
 * to support mutual recursion. This is the first visitor that must be called in order to populate
 * the symbol table with functions.
 */
public class FunctionVisitor extends FOOLBaseVisitor<INode>
{

    private Environment environment = new Environment();
    private ArrayList<FunctionAlreadyDefinedException> errors;

    @Override
    public INode visitType(FOOLParser.TypeContext ctx)
    {
        return new TypeNode(ctx, ctx.getText());
    }

    @Override
    public INode visitArgdec(FOOLParser.ArgdecContext ctx)
    {
        return visitType(ctx.type());
    }

    @Override
    public INode visitFun(FOOLParser.FunContext ctx)
    {
        INode type = visit(ctx.type());
        IType retType = ((TypeNode) type).getType();

        String funName= ctx.ID().getSymbol().getText();
        ArrayList<IType> paramsType = new ArrayList<>();

        for(FOOLParser.ArgdecContext argdecContext : ctx.argdec())
        {
            TypeNode param = (TypeNode) visit(argdecContext);
            paramsType.add(param.getType());
        }

        FunctionType funType = new FunctionType(retType, paramsType);

        try
        {
            //let's add symbol table entry for the function ID
            //TODO: check if this offset is ok
            environment.addEntry(ctx.ID().getSymbol(), funType, environment.offset, false);
        }
        catch(FunctionAlreadyDefinedException e)
        {
            errors.add(e);
        }

        return type;
    }

    public Environment getEnvironment()
    {
        return environment;
    }

    public ArrayList<FunctionAlreadyDefinedException> getErrors()
    {
        return errors;
    }

    public int getErrorsSize()
    {
        return errors.size();
    }

    public FunctionAlreadyDefinedException getError(int index)
    {
        return errors.get(index);
    }
}
