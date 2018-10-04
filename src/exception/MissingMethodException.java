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

    @Override
    public String getMessage()
    {
        return "Object " + objectID + " doesn't have a " + methodID + " method.";
    }
}
