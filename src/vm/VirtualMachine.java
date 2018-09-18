package vm;

import util.VMConfigReader;

public class VirtualMachine {

    public int heapPointer;
    public int stackPointer;
    private int instructionPointer;
    private int framePointer;
    private int returnAddress;
    private int returnValue;

    private int[] code;

    public VirtualMachine(int[] code) {
        heapPointer = 0;
        stackPointer = 0;
        instructionPointer = 0;
        framePointer = 0;
        this.code = code;
    }

}
