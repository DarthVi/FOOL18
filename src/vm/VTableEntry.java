package vm;

/**
 * Virtual function table entry (a.k.a. dispatch table entry), we
 * need it to allow dynamic dispatch
 */
public class VTableEntry
{
    private String methodID;
    private String methodLable;

    public String getMethodID()
    {
        return methodID;
    }

    public void setMethodID(String methodID)
    {
        this.methodID = methodID;
    }

    public String getMethodLable()
    {
        return methodLable;
    }

    public void setMethodLable(String methodLable)
    {
        this.methodLable = methodLable;
    }
}
