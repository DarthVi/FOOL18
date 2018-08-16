package vm;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores object's info used by the memory manager. More specifically we need
 * the location where the object is stored on the heap, a mark bit for the mark-and-sweep algorithm and the size, which
 * will be needed both for allocating and deallocating heap cells.
 */
public class ObjectInfo
{

    int startIndex;
    boolean markBit;
    int size;
    //virtual function table for the dynamic dispatching
    VTableEntry vtable;
    //an object may have other object as members, we need to keep track of them
    //for the mark-and-sweep algorithm and the table-compaction algorithm
    List<Integer> pointers;

    ObjectInfo(int start, boolean bit, int size, VTableEntry vtable)
    {
        this.startIndex = start;
        this.markBit = bit;
        this.size = size;
        pointers = new ArrayList<Integer>();
        this.vtable = vtable;
    }

    public int getStartIndex()
    {
        return startIndex;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    public boolean isMarked()
    {
        return markBit;
    }

    public void setMarkBit(boolean markBit)
    {
        this.markBit = markBit;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public void insertPointer(int index)
    {
        pointers.add(index);
    }

    public int getPointer(int index)
    {
        return pointers.get(index);
    }

    public VTableEntry getVtable()
    {
        return vtable;
    }

    public void setVtable(VTableEntry vtable)
    {
        this.vtable = vtable;
    }

}
