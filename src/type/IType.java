package type;

import ast.INode;

public interface IType {
    TypeID getTypeID();

    boolean isSubtypeOf(IType type);
}
