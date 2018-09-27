package util;

<<<<<<< HEAD
=======
import parser.FOOLParser;

>>>>>>> master
/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class DTableEntry
{
    private String methodId;
    private String methodLabel;
<<<<<<< HEAD

    public DTableEntry(String methodId, String methodLabel)
    {
        this.methodId = methodId;
        this.methodLabel = methodLabel;
=======
    private FOOLParser.FunContext ctx;

    public DTableEntry(String methodId, String methodLabel, FOOLParser.FunContext ctx)
    {
        this.methodId = methodId;
        this.methodLabel = methodLabel;
        this.ctx = ctx;
>>>>>>> master
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
<<<<<<< HEAD
=======

    public FOOLParser.FunContext getCtx()
    {
        return ctx;
    }
>>>>>>> master
}
