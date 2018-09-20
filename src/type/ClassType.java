package type;

import java.util.HashMap;
import java.util.Map;

public class ClassType implements IType
{
    private String className;
    private ClassType parent;
    private int dftIndex; //index to retrieve the appropriate index dispatch table
    private Map<String, ClassMember> classMembers;
    private Map<String, ClassMethod> classMethods;

    public ClassType(String className)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = new HashMap<>();
        this.classMethods = new HashMap<>();
    }

    public ClassType(String className, Map<String, ClassMember> classMembers)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = classMembers;
        this.classMethods = new HashMap<>();
    }

    public ClassType(String className, Map<String, ClassMember> classMembers, Map<String, ClassMethod> classMethods)
    {
        this.className = className;
        this.parent = null;
        this.classMembers = classMembers;
        this.classMethods = classMethods;
    }

    public ClassType(String className, ClassType parent, Map<String, ClassMember> classMembers, Map<String,
            ClassMethod> classMethods)
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

    public Map getClassMembers()
    {
        return classMembers;
    }

    public void setClassMembers(Map classMembers)
    {
        this.classMembers = classMembers;
    }

    public Map getClassMethods()
    {
        return classMethods;
    }

    public void setClassMethods(Map classMethods)
    {
        this.classMethods = classMethods;
    }

    public int getDftIndex()
    {
        return dftIndex;
    }

    public void setDftIndex(int dftIndex)
    {
        this.dftIndex = dftIndex;
    }

    @Override
    public String toString()
    {
        return "Class={className = " + this.className + ", parent = " + this.parent.getClassName() + "}";
    }
}
