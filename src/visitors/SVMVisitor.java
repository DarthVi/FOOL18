package visitors;

import org.antlr.v4.runtime.tree.ParseTree;
import parser.SVMBaseVisitor;
import parser.SVMParser;
import vm.MemoryManager;

import java.util.HashMap;

public class SVMVisitor extends SVMBaseVisitor
{
    private int[] code = new int[MemoryManager.readCodeSizeFromConfig()];
    private int i = 0;
    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();


    private void addCode(int c)
    {
        code[i++] = c;
    }

    @Override
    public Object visitCode(SVMParser.CodeContext ctx)
    {
        return visit(ctx);
    }

    @Override
    public Object visitPushNumber(SVMParser.PushNumberContext ctx)
    {
        addCode(SVMParser.PUSH);
        code[i++] = Integer.parseInt(ctx.n.getText());

        return code;
    }

    @Override
    public Object visitPushLabel(SVMParser.PushLabelContext ctx)
    {
        addCode(SVMParser.PUSH);
        labelRef.put(i++, ctx.l.getText());

        return code;
    }

    @Override
    public Object visitPop(SVMParser.PopContext ctx)
    {
        addCode(SVMParser.POP);
        return code;
    }

    @Override
    public Object visitAdd(SVMParser.AddContext ctx)
    {
        addCode(SVMParser.ADD);
        return code;
    }

    @Override
    public Object visitSub(SVMParser.SubContext ctx)
    {
        addCode(SVMParser.SUB);
        return code;
    }

    @Override
    public Object visitMult(SVMParser.MultContext ctx)
    {
        addCode(SVMParser.MULT);
        return code;
    }

    @Override
    public Object visitDiv(SVMParser.DivContext ctx)
    {
        addCode(SVMParser.DIV);
        return code;
    }

    @Override
    public Object visitStorew(SVMParser.StorewContext ctx)
    {
        addCode(SVMParser.STOREW);
        return code;
    }

    @Override
    public Object visitLoadw(SVMParser.LoadwContext ctx)
    {
        addCode(SVMParser.LOADW);
        return code;
    }

    @Override
    public Object visitLabelCol(SVMParser.LabelColContext ctx)
    {
        labelAdd.put(ctx.l.getText(), i);
        return code;
    }

    @Override
    public Object visitBranchLabel(SVMParser.BranchLabelContext ctx)
    {
        addCode(SVMParser.BRANCH);
        labelRef.put(i++, ctx.l.getText());
        return code;
    }

    //TODO: other visits MUST be coded and overridden
}
