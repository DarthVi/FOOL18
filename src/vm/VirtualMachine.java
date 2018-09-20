package vm;

import util.VMConfigReader;

public class VirtualMachine
{
    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;
    public int[] memory = new int[MEMSIZE];

    int hp;
    int sp;
    int ip;
    int fp;
    int ra;
    int rv;


    int[] code;

    public VirtualMachine(int[] code)
    {
        hp = 0;
        ip = 0;
        sp = MEMSIZE;
        fp = MEMSIZE;

        this.code = code;
    }

}
