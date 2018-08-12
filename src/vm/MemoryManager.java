package vm;

import util.VMConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    //list of objects allocated
    List<ObjectInfo> allocatedInstances = new ArrayList<ObjectInfo>();

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

        for( int i = 0; i < heapSize; i++)
        {
            freeHeapMemory.set(i, i);
        }

    }
}
