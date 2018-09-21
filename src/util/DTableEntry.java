package util;

import parser.FOOLParser;

/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class DTableEntry
{
    private String methodId;
    private String methodLabel;
    private FOOLParser.FunContext ctx;

    public DTableEntry(String methodId, String methodLabel, FOOLParser.FunContext ctx)
    {
        this.methodId = methodId;
        this.methodLabel = methodLabel;
        this.ctx = ctx;
    }

    public String getMethodId()
    {
        return methodId;
    }

    public void setMethodId(String methodId)
    {
        this.methodId = methodId;
    }

    public String getMethodLabel()
    {
        return methodLabel;
    }

    public void setMethodLabel(String methodLabel)
    {
        this.methodLabel = methodLabel;
    }

    public FOOLParser.FunContext getCtx()
    {
        return ctx;
    }
}
