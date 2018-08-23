package vm;

/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class VTableEntry
{
    private String methodID;
    private String methodLabel;

    public String getMethodID()
    {
        return methodID;
    }

    public void setMethodID(String methodID)
    {
        this.methodID = methodID;
    }

    public String getMethodLabel()
    {
        return methodLabel;
    }

    public void setMethodLabel(String methodLabel)
    {
        this.methodLabel = methodLabel;
    }
}
