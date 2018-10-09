package vm;

import exception.StackOverflowException;
import exception.StackUnderflowException;
import exception.VMOutOfMemoryException;
import util.VMConfigReader;

import java.util.*;

/**
 * Manages the memory space with utilities to allocate space and deallocate it via garbage collection (for the heap
 * space), push and pop (for the stack space)
 */
public class MemoryManager
{
    //TODO: progettare la dispatch table
    //stack size
    private int memorySize;
    //code size
    private int codeSize;
    //start memory address for the heap
    private int heapstart;

    public int[] memory;

    //map of objects allocated
    Map<Integer, ObjectInfo> allocatedInstances = new HashMap<Integer, ObjectInfo>();

    //list of indexes of free memory available
    List<Integer> freeHeapMemory;


    //table of break records used by the table-compaction algorithm
    Map<Integer, BreakRecord> breakRecords;

    int hp;
    int sp;
    int ip;
    int fp;
    int ra;
    int rv;

    public int getMemorySize()
    {
        return memorySize;
    }

    public void setMemorySize(int memorySize)
    {
        this.memorySize = memorySize;
    }

    public int getCodeSize()
    {
        return codeSize;
    }

    public void setCodeSize(int codeSize)
    {
        this.codeSize = codeSize;
    }

    public int getHeapstart()
    {
        return heapstart;
    }

    public void setHeapstart(int heapstart)
    {
        this.heapstart = heapstart;
    }

    public static int readCodeSizeFromConfig()
    {
        VMConfigReader configReader = new VMConfigReader("vm/vmconfig.properties");
        int codesize = configReader.getCodeSize();
        configReader.closePropFile();
        return codesize;
    }

    public MemoryManager()
    {
        VMConfigReader configReader = new VMConfigReader("vm/vmconfig.properties");
        memorySize = configReader.getMemorySize();
        codeSize = configReader.getCodeSize();
        heapstart = configReader.getHeapStart();
        configReader.closePropFile();

        freeHeapMemory = new ArrayList<Integer>(memorySize);
        memory = new int[memorySize];

        for( int i = heapstart; i < memorySize; i++)
        {
            freeHeapMemory.add(i, i);
        }

        hp = heapstart;
        ip = 0;
        sp = memorySize;
        fp = memorySize;

    }

    public void setMemory(int address, int value)
    {
        memory[address] = value;
    }

    public int getMemory(int address)
    {
        return memory[address];
    }

    /**
     * pushes a value at the top of the stack of the virtual machine
     * @param value
     * @throws StackOverflowException
     */
    public void push(int value) throws StackOverflowException
    {
        if(sp - 1 < 0 || sp - 1 < hp)
            throw new StackOverflowException();

        memory[--sp] = value;
    }

    /**
     * Pops values from the stack
     * @throws StackUnderflowException
     */
    public int pop() throws StackUnderflowException
    {
        if (sp + 1 > this.memorySize)
            throw new StackUnderflowException();

        int retValue = memory[sp];
        memory[sp] = 0;
        sp++;

        return retValue;
    }

    /**
     * Allocates a chunk of memory of dimension size from the heap memory. It also adds some info about allocation
     * in the allocatedInstance list (it will be needed for garbage collection) and removes entries from the
     * freeHeapMemory list.
     *
     * Returns an ObjectInfo
     * @param size
     * @return  ObjectInfo containing startIndex, size and pointers list
     * @throws VMOutOfMemoryException
     */
    public ObjectInfo allocate(int size, int[] args, int dispatchTableAddress) throws VMOutOfMemoryException
    {


        if(freeHeapMemory.size() < size + 1 || hp + 1 > sp)
            throw new VMOutOfMemoryException();

        int startIndex = freeHeapMemory.get(0);
        ObjectInfo objinfo = new ObjectInfo(startIndex, false, size);
        allocatedInstances.put(startIndex, objinfo);

        ListIterator<Integer> iterator = freeHeapMemory.listIterator();

        int i = 0;
        while(iterator.hasNext() && i < size + 1)
        {
            iterator.next();
            iterator.remove();
            i++;
        }

//        for(int i = 0; i < size + 1; i++)
//            freeHeapMemory.remove(i);

        int j;
        memory[startIndex] = dispatchTableAddress;
        for(i = startIndex + 1, j = 0; i < startIndex + 1 + size; i++, j++)
            memory[i] = args[j];

        hp += size + 1;


        return objinfo;
    }

    /**
     * Deallocates memory on the heap, adding it to the freeHeapMemory and removing data from the allocatedIstances
     * @param index
     * @param size
     */
    public void deallocate(int index, int size)
    {

        allocatedInstances.remove(index);

        for(int i = index; i < index + size; i++)
        {
            memory[i] = 0;
            freeHeapMemory.add(i);
        }

        hp -= size;

        Collections.sort(freeHeapMemory);
    }

    public ObjectInfo getObjInfo(int address)
    {
        return allocatedInstances.get(address);
    }

}
