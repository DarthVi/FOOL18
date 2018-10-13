package exception;

public class StackOverflowException extends RuntimeException
{
    public StackOverflowException()
    {
        super("No more stack space available: stack overflow.");
    }
}
