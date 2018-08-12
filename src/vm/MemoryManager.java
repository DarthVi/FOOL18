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
    //stack size
    private int memorySize;
    //code size
    private int codeSize;
    //heap size
    private int heapSize;

    private int[] stackMemory;

    //map of objects allocated
    Map<Integer, ObjectInfo> allocatedInstances = new HashMap<Integer, ObjectInfo>();

    //list of indexes of free memory available
    List<Integer> freeHeapMemory;

    //table of break records used by the table-compaction algorithm
    Map<Integer, BreakRecord> breakRecords;

    public MemoryManager()
    {
        VMConfigReader configReader = new VMConfigReader("vmconfig.properties");
        memorySize = configReader.getMemorySize();
        codeSize = configReader.getCodeSize();
        heapSize = configReader.getHeapSize();
        configReader.closePropFile();

        freeHeapMemory = new ArrayList<Integer>(heapSize);
        stackMemory = new int[memorySize];

        for( int i = 0; i < heapSize; i++)
        {
            freeHeapMemory.set(i, i);
        }

    }

    /**
     * pushes a value at the top of the stack of the virtual machine
     * @param value
     * @param vm
     * @throws StackOverflowException
     */
    public void push(int value, VirtualMachine vm) throws StackOverflowException
    {
        if(vm.sp + 1 > this.memorySize)
            throw new StackOverflowException();

        stackMemory[vm.sp++] = value;
    }

    /**
     * Pops values from the stack
     * @param value
     * @param vm
     * @throws StackUnderflowException
     */
    public void pop(int value, VirtualMachine vm) throws StackUnderflowException
    {
        if (vm.sp - 1 < 0)
            throw new StackUnderflowException();

        vm.sp--;
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
    public ObjectInfo allocate(int size) throws VMOutOfMemoryException
    {
        if(freeHeapMemory.size() < size)
            throw new VMOutOfMemoryException();

        int startIndex = freeHeapMemory.get(0);
        ObjectInfo objinfo = new ObjectInfo(startIndex, false, size);
        allocatedInstances.put(startIndex, objinfo);
        freeHeapMemory.remove(0);
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
            freeHeapMemory.add(i);
        }

        Collections.sort(freeHeapMemory);
    }

}
