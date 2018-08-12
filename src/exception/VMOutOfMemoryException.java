package exception;

public class VMOutOfMemoryException extends Exception
{
    public VMOutOfMemoryException()
    {
        super("No more heap memory available: VM out of memory");
    }
}
