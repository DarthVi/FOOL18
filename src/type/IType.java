package type;

public interface IType
{
    TypeID getTypeID();

    boolean isSubtypeOf(IType type);
}
