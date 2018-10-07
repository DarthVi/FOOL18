package ast;

import exception.TypeException;
import org.antlr.v4.runtime.ParserRuleContext;
import type.IType;
import type.NullType;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NullNode implements INode
{
    private ParserRuleContext ctx;
    private String classID;

    public NullNode(ParserRuleContext ctx)
    {
        this.ctx = ctx;
        this.classID = "null";
    }

    public void setClassID(String classID)
    {
        this.classID = classID;
    }

    @Override
    public String toString()
    {
        return "null";
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        return new NullType();
    }

    @Override
    public String codeGeneration()
    {
        //TODO: is -1 a good value for null? Supposedly yes, we cannot have negative addresses for objects, but
        //we can have objects stored in the memory starting from address 0


        //when coding the VM we must remember to check that if both arguments size and labels
        //are equal to -1, we have a null reference initialization
        return "push -1\n" +
                "push class" + classID + "\n" +
                "new\n";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        return new ArrayList<SemanticError>();
    }
}
