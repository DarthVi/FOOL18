package type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassType implements IType
{
    private String className;
    private ClassType parent;
    private Map<String, ClassMember> classMembers;

    public ArrayList<ClassMember> getDeclaredOrderMembers()
    {
        return declaredOrderMembers;
    }

    public void setDeclaredOrderMembers(ArrayList<ClassMember> declaredOrderMembers)
    {
        this.declaredOrderMembers = declaredOrderMembers;
    }

    //we need the members orderet exactly as they were declared
    //in order to make the new operator work.
    private ArrayList<ClassMember> declaredOrderMembers = null;
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
        if(type instanceof NullType)
            return true;

        if(type instanceof ClassType)
        {

            ClassType argType = (ClassType) type;

            if(this.getClassName().equals(argType.getClassName()))
                return true;


            if(this.parent != null)
                return this.parent.getClassName().equals(argType.getClassName()) ||
                        this.parent.isSubtypeOf(type);
        }

        return false;
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

    @Override
    public String toString()
    {
        return this.className;
    }
}
