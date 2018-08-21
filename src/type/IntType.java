package type;

public class IntType implements IType
{
    @Override
    public TypeID getTypeID()
    {
        return TypeID.INT;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        return this.getTypeID() == type.getTypeID();
    }

    @Override
    public String toString()
    {
        return "int";
    }
}
