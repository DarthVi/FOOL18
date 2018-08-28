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
        return this.getTypeID() == type.getTypeID();
    }

    @Override
    public String toString()
    {
        return "null";
    }
}
