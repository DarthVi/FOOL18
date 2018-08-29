package exception;

public class StackUnderflowException extends RuntimeException
{
    public StackUnderflowException()
    {
        super("Cannot go lower in the stack: stack underflow.");
    }
}
