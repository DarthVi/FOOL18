package type;

import java.lang.reflect.Type;
import java.util.List;

public class FunctionType implements IType
{
    private IType returnType;
    private List<IType> argumentsType;

    public FunctionType(IType returnType, List<IType> argumentsType)
    {
        this.returnType = returnType;
        this.argumentsType = argumentsType;
    }

    @Override
    public TypeID getTypeID()
    {
        return TypeID.FUNCTION;
    }

    @Override
    public boolean isSubtypeOf(IType type)
    {
        return this.getTypeID() == type.getTypeID();
    }

    public IType getReturnType()
    {
        return returnType;
    }

    public List<IType> getArgumentsType()
    {
        return argumentsType;
    }

    /**
     * It tests if the return type is covariant and the arguments are controvariant
     * @param function
     * @return  true if we are overriding the function passed as argument
     */
    public boolean isOverriding(FunctionType function)
    {
        //return type must be covariant
        if(!this.getReturnType().isSubtypeOf(function.getReturnType()))
            return false;

        int size = this.getArgumentsType().size();

        //same number of arguments in the signature
        if(size != function.getArgumentsType().size())
            return false;

        //arguments must be controvariant
        List<IType> thisArgumentsList = this.getArgumentsType();
        List<IType>  argumentsList = function.getArgumentsType();
        for(int i = 0; i< size; i++)
        {
            if(!argumentsList.get(i).isSubtypeOf(thisArgumentsList.get(i)))
                return false;
        }

        return true;
    }

    /**
     * It returns true if this function is overloading the one passed as argument
     * @param function
     * @return  true if this function is overloading the one passed as argument
     */
    public boolean isOverloading(FunctionType function)
    {
        if(this.getReturnType() != function.getReturnType())
            return true;

        int thisSize = this.getArgumentsType().size();
        int size = function.getArgumentsType().size();

        if(thisSize != size)
            return true;

        List<IType> thisArgumentsList = this.getArgumentsType();
        List<IType>  argumentsList = function.getArgumentsType();

        for(int i = 0; i < size; i++)
        {
            if(argumentsList.get(i) != thisArgumentsList.get(i))
                return true;
        }

        return false;
    }
}
