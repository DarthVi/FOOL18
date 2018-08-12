package exception;

public class StackUnderflowException extends Exception
{
    public StackUnderflowException()
    {
        super("Cannot go lower in the stack: stack underflow.");
    }
}
