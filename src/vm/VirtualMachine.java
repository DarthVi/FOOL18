package vm;

import util.VMConfigReader;

public class VirtualMachine
{

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
        sp = 0;
        ip = 0;
        fp = 0;



        this.code = code;
    }
}
