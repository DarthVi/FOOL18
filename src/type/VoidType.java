package type;

public class VoidType implements IType
{
    @Override
    public TypeID getTypeID()
    {
        return TypeID.VOID;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        return this.getTypeID() == type.getTypeID();
    }

    @Override
    public String toString()
    {
        return "void";
    }
}
