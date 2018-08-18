package ast;

import type.IType;

public class STentry
{
    private int nestingLevel;
    private IType type;
    private int offset;
    private boolean isAttribute;

    public STentry(int nestingLevel, IType type, int offset)
    {
        this.nestingLevel = nestingLevel;
        this.type = type;
        this.offset = offset;
        this.isAttribute = false;
    }

    public STentry(int nestingLevel, IType type, int offset, boolean isAttribute)
    {
        this.nestingLevel = nestingLevel;
        this.type = type;
        this.offset = offset;
        this.isAttribute = isAttribute;
    }

    public int getNestingLevel()
    {
        return nestingLevel;
    }

    public void setNestingLevel(int nestingLevel)
    {
        this.nestingLevel = nestingLevel;
    }

    public IType getType()
    {
        return type;
    }

    public void setType(IType type)
    {
        this.type = type;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public boolean isAttribute()
    {
        return isAttribute;
    }

    public void setAttribute(boolean attribute)
    {
        isAttribute = attribute;
    }

    public String toString(String s)
    {
        return "STentry: nestingLevel " + this.nestingLevel + "\n" +
               "STentry: type " + type +
               "STentry: offset" + offset +
               "STentry: isAttribute" + isAttribute;
    }
}
