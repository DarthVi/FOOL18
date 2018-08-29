package type;

public class ClassMember
{
    private String memberID;
    private IType type;

    public ClassMember(String memberID, IType type)
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
}
