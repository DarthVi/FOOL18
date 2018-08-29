package vm;

/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class VTableEntry
{
    private String methodAddress;
    private String methodLabel;

    public String getMethodAddress()
    {
        return methodAddress;
    }

    public void setMethodAddress(String methodAddress)
    {
        this.methodAddress = methodAddress;
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
