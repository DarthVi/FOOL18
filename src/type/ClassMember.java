package type;

import java.util.Objects;

public class ClassMember
{
    private String memberID;
    private IType type;

    public ClassMember(String memberID, IType type)
    {
        this.memberID = memberID;
        this.type = type;
    }

    public ClassMember(String memberID, IType type, int value)
    {
        this.memberID = memberID;
        this.type = type;
    }


    public String getMemberID()
    {
        return memberID;
    }

    public void setMemberID(String memberID)
    {
        this.memberID = memberID;
    }

    public IType getType()
    {
        return type;
    }

    public void setType(IType type)
    {
        this.type = type;
    }

    //This is gonna be useful when we will use an hashmap of members to store their values
    //inside specific classes that encode instances.
    //It is necessary to override this method in order to appropriately use this class
    //as an hashmap key
    @Override
    public boolean equals(Object o)
    {
        return ((o instanceof ClassMember) && this.memberID.equals( ( (ClassMember) o).memberID ));
    }

    //This is gonna be useful when we will use an hashmap of members to store their values
    //inside specific classes that encode instances.
    /**
     * The hash code of this class is the hashcode of its name, which is a string
     * @return  an integer representing the hashcode
     */
    @Override
    public int hashCode()
    {

        return this.memberID.hashCode();
    }
}
