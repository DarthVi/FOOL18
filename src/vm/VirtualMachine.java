package vm;

import parser.SVMParser;
import util.VMConfigReader;

public class VirtualMachine
{
    private MemoryManager memoryManager;


    int[] code;

    public VirtualMachine(int[] code)
    {
        memoryManager = new MemoryManager();
        this.code = code;
    }

    public int cpu() {

        //int iter = 0;

        while ( true ) {
            int bytecode = code[memoryManager.ip++]; // fetch
            // System.out.println("\n" + bytecode);

            int v1,v2, value;
            int address;

            switch ( bytecode ) {
                case SVMParser.PUSH:
                    //System.out.println("Iterazione: " + iter);
                    int c = code[memoryManager.ip++];
                    memoryManager.push(c);
                    break;
                case SVMParser.POP:
                    memoryManager.pop();
                    break;
                case SVMParser.ADD :
                    v1 = memoryManager.pop();
                    v2 = memoryManager.pop();
                    memoryManager.push(v2 + v1);
                    break;
                case SVMParser.MULT :
                    v1 = memoryManager.pop();
                    v2 = memoryManager.pop();
                    memoryManager.push(v2 * v1);
                    break;
                case SVMParser.DIV :
                    v1 = memoryManager.pop();
                    v2 = memoryManager.pop();
                    memoryManager.push(v2 / v1);
                    break;
                case SVMParser.SUB :
                    v1 = memoryManager.pop();
                    v2 = memoryManager.pop();
                    memoryManager.push(v2 - v1);
                    break;
                case SVMParser.STOREW : //
                    address = memoryManager.pop();
                    value = memoryManager.pop();
                    memoryManager.setMemory(address, value);
                    break;
                case SVMParser.LOADW : //
                    address = memoryManager.pop();
                    value = memoryManager.getMemory(address);
                    memoryManager.push(value);
                    break;
                case SVMParser.BRANCH :
                    address = code[memoryManager.ip];
                    memoryManager.ip = address;
                    break;
                case SVMParser.BRANCHEQ : //
                    address = code[memoryManager.ip++];
                    v1=memoryManager.pop();
                    v2=memoryManager.pop();
                    if (v2 == v1) memoryManager.ip = address;
                    break;
                case SVMParser.BRANCHLESSEQ :
                    address = code[memoryManager.ip++];
                    v1=memoryManager.pop();
                    v2=memoryManager.pop();
                    if (v2 <= v1) memoryManager.ip = address;
                    break;
                case SVMParser.JS : //
                    address = memoryManager.pop();
                    memoryManager.ra = memoryManager.ip;
                    memoryManager.ip = address;
                    break;
                case SVMParser.STORERA : //
                    memoryManager.ra = memoryManager.pop();
                    break;
                case SVMParser.LOADRA : //
                    memoryManager.push(memoryManager.ra);
                    break;
                case SVMParser.STORERV : //
                    memoryManager.rv = memoryManager.pop();
                    break;
                case SVMParser.LOADRV : //
                    memoryManager.push(memoryManager.rv);
                    break;
                case SVMParser.LOADFP : //
                    memoryManager.push(memoryManager.fp);
                    break;
                case SVMParser.STOREFP : //
                    memoryManager.fp = memoryManager.pop();
                    break;
                case SVMParser.COPYFP : //
                    memoryManager.fp = memoryManager.sp;
                    break;
                case SVMParser.STOREHP : //
                    memoryManager.hp = memoryManager.pop();
                    break;
                case SVMParser.LOADHP : //
                    memoryManager.push(memoryManager.hp);
                    break;
                case SVMParser.PRINT :
                    System.out.println((memoryManager.sp < memoryManager.getMemorySize()) ?
                            memoryManager.getMemory(memoryManager.sp) :
                            "Empty stack!");
                    break;
                case SVMParser.NEW:
                    //lets get the address of the dispatch function table
                    int dftAddress = memoryManager.pop();
                    //the number of arguments passed to the constructor
                    int numArgs = memoryManager.pop();
                     //memoryManager.allocate(1,new int[]{dftAddress});
                    if(numArgs >= 0)
                    {
                        int[] arguments = new int[numArgs];

                        for (int i = numArgs - 1; i >= 0; i--)
                            arguments[i] = memoryManager.pop();

                        ObjectInfo object = memoryManager.allocate(numArgs, arguments, dftAddress);
                        memoryManager.push(object.getStartIndex());
                        //setting the dispatch table address
                        object.setDftAddress(dftAddress);
                    }
                    else
                        memoryManager.push(-1);

                    break;
                case SVMParser.LC:
                    address = memoryManager.pop();
                    memoryManager.push(code[address]);
                    break;
                case SVMParser.COPY:
                    value = memoryManager.getMemory(memoryManager.sp);
                    memoryManager.push(value);
                    break;
                case SVMParser.CALCHOFF:
                    int objectAddress = memoryManager.pop();
                    int objectOffset = memoryManager.pop();
                   // System.out.println(objectAddress + "  " + objectOffset);


                    ObjectInfo objInfo = memoryManager.getObjInfo(objectAddress);

                    int fieldAdd = objInfo.startIndex + objectOffset;
                    int realOffset = fieldAdd - objectAddress;
                    memoryManager.push(realOffset);
                    memoryManager.push(objectAddress);
                    break;
                case SVMParser.MM:
                    value = memoryManager.pop();
                    int oAddr = memoryManager.pop();
                    int indexOfMember = memoryManager.pop();
                    int realAddress = oAddr + indexOfMember + 1;
                    memoryManager.setMemory(realAddress, value);
                    memoryManager.push(value);
                    break;
                case SVMParser.HALT :
                    System.out.println((memoryManager.sp < memoryManager.getMemorySize()) ?
                            "Last value before halting: " + memoryManager.getMemory(memoryManager.sp) :
                            "Empty stack!");
                    return  memoryManager.getMemory(memoryManager.sp);
            }

            //iter++;
        }
    }

}
