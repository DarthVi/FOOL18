package exception;

public class VMOutOfMemoryException extends RuntimeException
{
    public VMOutOfMemoryException()
    {
        super("No more heap memory available: VM out of memory");
    }
}
