package type;

public class ClassMember
{
    private String memberID;
    private IType type;
    private int value;

    public ClassMember(String memberID, IType type)
    {
        this.memberID = memberID;
        this.type = type;
        this.value = 0;
    }

    public ClassMember(String memberID, IType type, int value)
    {
        this.memberID = memberID;
        this.type = type;
        this.value =value;
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

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
