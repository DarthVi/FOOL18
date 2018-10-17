package exception;

public class MissingMethodException extends RuntimeException
{
    private String objectID;
    private String methodID;

    public MissingMethodException(String objectID, String methodID)
    {
        this.objectID = objectID;
        this.methodID = methodID;
    }

    public MissingMethodException(String methodID)
    {
        this.objectID = null;
        this.methodID = methodID;
    }

    @Override
    public String getMessage()
    {
        if(objectID != null)
            return "Object " + objectID + " doesn't have a " + methodID + " method.";
        else
            return "Method " + methodID + " not defined in the class that uses it.";
    }
}
