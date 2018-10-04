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

    public void cpu() {

        //int iter = 0;

        while ( true ) {
            //System.out.println("IP: " + memoryManager.ip);
            int bytecode = code[memoryManager.ip++]; // fetch
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
                    int[] arguments = new int[numArgs];

                    for(int i = numArgs - 1; i >= 0; i--)
                        arguments[i] = memoryManager.pop();

                    ObjectInfo object = memoryManager.allocate(numArgs, arguments);
                    //setting the dispatch table address
                      object.setDftAddress(dftAddress);
                    break;
                case SVMParser.LC:
                    address = memoryManager.pop();
                    for(int i=0;i< 80; i++) System.out.print(i+"="+code[i]+", ");
                    System.out.println(address);
                    memoryManager.push(code[address]);
                    break;
                case SVMParser.CALCHOFF:
                    int objectAddress = memoryManager.pop();
                    int objectOffset = memoryManager.pop();

                    ObjectInfo objInfo = memoryManager.getObjInfo(objectAddress);
                    int realOffset = objInfo.startIndex + objectOffset;
                    memoryManager.push(realOffset);
                    memoryManager.push(objectAddress);
                    break;
                case SVMParser.HALT :
                    System.out.println((memoryManager.sp < memoryManager.getMemorySize()) ?
                            memoryManager.getMemory(memoryManager.sp) :
                            "Empty stack!");
                    return;
            }

            //iter++;
        }
    }

}
