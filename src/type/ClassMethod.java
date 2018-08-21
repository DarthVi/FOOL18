package type;

public class ClassMethod
{
    private String methodID;
    private FunctionType methodType;

    public ClassMethod(String methodID, FunctionType methodType)
    {
        this.methodID = methodID;
        this.methodType = methodType;
    }

    public String getMethodID()
    {
        return methodID;
    }

    public void setMethodID(String methodID)
    {
        this.methodID = methodID;
    }

    public FunctionType getMethodType()
    {
        return methodType;
    }

    public void setMethodType(FunctionType methodType)
    {
        this.methodType = methodType;
    }
}
