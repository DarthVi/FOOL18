package visitors;

import org.antlr.v4.runtime.tree.ParseTree;
import parser.SVMBaseVisitor;
import parser.SVMParser;
import vm.MemoryManager;

import java.util.HashMap;

/**
 * Visits the SVM tree and populates the code array appropriately.
 */
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

    @Override
    public Object visitBranchEqLabel(SVMParser.BranchEqLabelContext ctx)
    {
        addCode(SVMParser.BRANCHEQ);
        labelRef.put(i++, ctx.l.getText());
        return code;
    }

    @Override
    public Object visitBranchLessEqLabel(SVMParser.BranchLessEqLabelContext ctx)
    {
        addCode(SVMParser.BRANCHLESSEQ);
        labelRef.put(i++, ctx.l.getText());
        return code;
    }

    @Override
    public Object visitJs(SVMParser.JsContext ctx)
    {
        addCode(SVMParser.JS);
        return code;
    }

    @Override
    public Object visitLoadRa(SVMParser.LoadRaContext ctx)
    {
        addCode(SVMParser.LOADRA);
        return code;
    }

    @Override
    public Object visitStoreRa(SVMParser.StoreRaContext ctx)
    {
        addCode(SVMParser.STORERA);
        return code;
    }

    @Override
    public Object visitLoadRv(SVMParser.LoadRvContext ctx)
    {
        addCode(SVMParser.LOADRV);
        return code;
    }

    @Override
    public Object visitStoreRv(SVMParser.StoreRvContext ctx)
    {
        addCode(SVMParser.STORERV);
        return code;
    }

    @Override
    public Object visitLoadFp(SVMParser.LoadFpContext ctx)
    {
        addCode(SVMParser.LOADFP);
        return code;
    }

    @Override
    public Object visitStoreFp(SVMParser.StoreFpContext ctx)
    {
        addCode(SVMParser.STOREFP);
        return code;
    }

    @Override
    public Object visitCopyFp(SVMParser.CopyFpContext ctx)
    {
        addCode(SVMParser.COPYFP);
        return code;
    }

    @Override
    public Object visitLoadHp(SVMParser.LoadHpContext ctx)
    {
        addCode(SVMParser.LOADHP);
        return code;
    }

    @Override
    public Object visitStoreHp(SVMParser.StoreHpContext ctx)
    {
        addCode(SVMParser.STOREHP);
        return code;
    }

    @Override
    public Object visitPrint(SVMParser.PrintContext ctx)
    {
        addCode(SVMParser.PRINT);
        return code;
    }

    @Override
    public Object visitHalt(SVMParser.HaltContext ctx)
    {
        addCode(SVMParser.HALT);
        return code;
    }

    /**
     * After having collected references, we must put them them where needed in order
     * to be used appropriately in the VM code.
     */
    public void patchCodeWithIndexes()
    {
        for(Integer refAdd : labelRef.keySet())
            code[refAdd] = labelAdd.get(labelRef.get(refAdd));
    }

    public int[] getCode()
    {
        return code;
    }

}
