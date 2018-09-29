package type;

public class NullType implements IType
{
    @Override
    public TypeID getTypeID()
    {
        return TypeID.NULL;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        //null is considered a "correct type" for every class
        //except for primitive types such as integers, boolean, functions, etc.
        return (type instanceof ClassType);
    }

    @Override
    public String toString()
    {
        return "null";
    }
}
