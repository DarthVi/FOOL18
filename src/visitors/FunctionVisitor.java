package visitors;

import ast.INode;
import ast.TypeNode;
import exception.FunctionAlreadyDefinedException;
import parser.FOOLBaseVisitor;
import parser.FOOLParser;
import type.FunctionType;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

/**
 * We need a first pass to get all the function declarations in order to be able
 * to support mutual recursion. This is the first visitor that must be called in order to populate
 * the symbol table with functions.
 */
public class FunctionVisitor extends FOOLBaseVisitor<INode>
{

    private Environment environment = new Environment();
    private ArrayList<SemanticError> errors = new ArrayList<>();

    public FunctionVisitor()
    {
        environment.offset = -2;
    }

    @Override
    public INode visitType(FOOLParser.TypeContext ctx)
    {
        return new TypeNode(ctx, ctx.getText());
    }

    @Override
    public INode visitVardec(FOOLParser.VardecContext ctx)
    {
        environment.offset--;
        return null;
    }

    @Override
    public INode visitArgdec(FOOLParser.ArgdecContext ctx)
    {
        return visitType(ctx.type());
    }

    @Override
    public INode visitFun(FOOLParser.FunContext ctx)
    {
        if(!FOOLParser.ruleNames[ctx.getParent().getRuleIndex()].equals(FOOLParser.ruleNames[FOOLParser.RULE_classdec]))
        {
            INode type = visit(ctx.type());
            IType retType = ((TypeNode) type).getType();

            String funName = ctx.ID().getSymbol().getText();
            ArrayList<IType> paramsType = new ArrayList<>();

            for (FOOLParser.ArgdecContext argdecContext : ctx.argdec())
            {
                TypeNode param = (TypeNode) visit(argdecContext);
                paramsType.add(param.getType());
            }

            FunctionType funType = new FunctionType(retType, paramsType);

            try
            {
                if (environment.getNestingLevel() == -1) //symtable empty
                    environment.addHashMap();

                //let's add symbol table entry for the function ID
                //TODO: check if this offset is ok
                environment.addEntry(ctx.ID().getSymbol(), funType, environment.offset--, false);
            } catch (FunctionAlreadyDefinedException e)
            {
                errors.add(new SemanticError(e.getMessage()));
            }

            return type;
        }
        else
            return null;
    }

    public Environment getEnvironment()
    {
        return environment;
    }

    public ArrayList<SemanticError> getErrors()
    {
        return errors;
    }

    public int getErrorsSize()
    {
        return errors.size();
    }

    public SemanticError getError(int index)
    {
        return errors.get(index);
    }
}
