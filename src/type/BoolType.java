package type;

public class BoolType implements IType
{
    @Override
    public TypeID getTypeID()
    {
        return TypeID.BOOL;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        return this.getTypeID() == type.getTypeID();
    }

    @Override
    public String toString()
    {
        return "bool";
    }
}
