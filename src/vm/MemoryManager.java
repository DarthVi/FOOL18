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
    //start memory address for the heap
    private int heapstart;

    private int[] memory;

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
        heapstart = configReader.getHeapStart();
        configReader.closePropFile();

        freeHeapMemory = new ArrayList<Integer>(memorySize);
        memory = new int[memorySize];

        for( int i = heapstart -1; i >= 0; i--)
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
        if(vm.sp + 1 > this.memorySize || vm.sp + 1 > vm.hp)
            throw new StackOverflowException();

        memory[vm.sp++] = value;
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
    public ObjectInfo allocate(int size, int[] args, VirtualMachine vm) throws VMOutOfMemoryException
    {
        //TODO: progettare la dispatch table

        if(freeHeapMemory.size() < size || vm.hp - 1 < vm.sp)
            throw new VMOutOfMemoryException();

        int startIndex = freeHeapMemory.get(0);
        ObjectInfo objinfo = new ObjectInfo(startIndex, false, size);
        allocatedInstances.put(startIndex, objinfo);

        for(int i = 0; i < size; i++)
            freeHeapMemory.remove(i);

        //TODO: mettere in memory l'indirizzo della dispatch table e gli argomenti

        return objinfo;
    }

    /**
     * Deallocates memory on the heap, adding it to the freeHeapMemory and removing data from the allocatedIstances
     * @param index
     * @param size
     */
    public void deallocate(int index, int size)
    {

        //TODO: aggiustare questa funzione tenendo conto della dispatch table in memory e dei valori sempre in memory

        allocatedInstances.remove(index);

        for(int i = index; i < index + size; i++)
        {
            freeHeapMemory.add(i);
        }

        Collections.sort(freeHeapMemory);
    }

}
