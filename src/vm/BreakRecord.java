package vm;

/**
 * Break record for the break table used in the table-compaction algorithm
 */
public class BreakRecord
{
    int oldIndex;
    //difference between the old index and the new index
    int diff;

    public int getOldIndex()
    {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex)
    {
        this.oldIndex = oldIndex;
    }

    public int getDiff()
    {
        return diff;
    }

    public void setDiff(int diff)
    {
        this.diff = diff;
    }
}
