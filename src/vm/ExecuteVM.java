package vm;

import util.VMConfigReader;

public class ExecuteVM
{

    private int hp;
    private int sp;
    private int ip;
    private int fp;
    private int ra;
    private int rv;

    int[] code;

    public ExecuteVM(int[] code)
    {
        hp = 0;
        sp = 0;
        ip = 0;
        fp = 0;



        this.code = code;
    }
}
