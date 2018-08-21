package type;

import java.util.ArrayList;
import java.util.List;

public class ClassType implements IType
{
    private String className;
    private ClassType parent;
    private List<IType> classMembers;
    private List<FunctionType> classMethods;

    public ClassType(String className)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = new ArrayList<>();
        this.classMethods = new ArrayList<>();
    }

    public ClassType(String className, List<IType> classMembers)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = classMembers;
        this.classMethods = new ArrayList<>();
    }

    public ClassType(String className, List<IType> classMembers, List<FunctionType> classMethods)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = classMembers;
        this.classMethods = classMethods;
    }

    public ClassType(String className, ClassType parent, List<IType> classMembers, List<FunctionType> classMethods)
    {
        this.className = className;
        this.parent = parent;
        this.classMembers = classMembers;
        this.classMethods = classMethods;
    }

    public void addParent(ClassType parent)
    {
        this.parent = parent;
    }

    @Override
    public TypeID getTypeID()
    {
        return TypeID.CLASS;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        ClassType parent = (ClassType) type;

        return this.parent.getClassName().equals(parent.getClassName());
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public ClassType getParent()
    {
        return parent;
    }

    public void setParent(ClassType parent)
    {
        this.parent = parent;
    }

    public List<IType> getClassMembers()
    {
        return classMembers;
    }

    public void setClassMembers(List<IType> classMembers)
    {
        this.classMembers = classMembers;
    }

    public List<FunctionType> getClassMethods()
    {
        return classMethods;
    }

    public void setClassMethods(List<FunctionType> classMethods)
    {
        this.classMethods = classMethods;
    }

    @Override
    public String toString()
    {
        return "Class={className = " + this.className + ", parent = " + this.parent.getClassName() + "}";
    }
}
