package vm;

/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class DTableEntry
{
    private String methodId;
    private String methodLabel;

    public DTableEntry(String methodId, String methodLabel)
    {
        this.methodId = methodId;
        this.methodLabel = methodLabel;
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
}
