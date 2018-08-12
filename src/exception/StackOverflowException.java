package exception;

public class StackOverflowException extends Exception
{
    public StackOverflowException()
    {
        super("No more stack space available: stack overflow.");
    }
}
