package vm;

import parser.SVMParser;
import vm.VirtualMachine;

public class ExecuteVM {

    private  VirtualMachine virtualMachine ;

    public ExecuteVM(int[] code) {
        this.virtualMachine = new VirtualMachine(code);
    }

    public void cpu() {
        while ( true ) {
            int bytecode = virtualMachine.code[virtualMachine.ip++]; // fetch
            int v1,v2;
            int address;

            switch ( bytecode ) {
                case SVMParser.PUSH:
                    push( virtualMachine.code[virtualMachine.ip++] );
                    break;
                case SVMParser.POP:
                    pop();
                    break;
                case SVMParser.ADD :
                    v1=pop();
                    v2=pop();
                    push(v2 + v1);
                    break;
                case SVMParser.MULT :
                    v1=pop();
                    v2=pop();
                    push(v2 * v1);
                    break;
                case SVMParser.DIV :
                    v1=pop();
                    v2=pop();
                    push(v2 / v1);
                    break;
                case SVMParser.SUB :
                    v1=pop();
                    v2=pop();
                    push(v2 - v1);
                    break;
                case SVMParser.STOREW : //
                    address = pop();
                    virtualMachine.memory[address] = pop();
                    break;
                case SVMParser.LOADW : //
                    push(virtualMachine.memory[pop()]);
                    break;
                case SVMParser.BRANCH :
                    address = virtualMachine.code[virtualMachine.ip];
                    virtualMachine.ip = address;
                    break;
                case SVMParser.BRANCHEQ : //
                    address = virtualMachine.code[virtualMachine.ip++];
                    v1=pop();
                    v2=pop();
                    if (v2 == v1) virtualMachine.ip = address;
                    break;
                case SVMParser.BRANCHLESSEQ :
                    address = virtualMachine.code[virtualMachine.ip++];
                    v1=pop();
                    v2=pop();
                    if (v2 <= v1) virtualMachine.ip = address;
                    break;
                case SVMParser.JS : //
                    address = pop();
                    virtualMachine.ra = virtualMachine.ip;
                    virtualMachine.ip = address;
                    break;
                case SVMParser.STORERA : //
                    virtualMachine.ra=pop();
                    break;
                case SVMParser.LOADRA : //
                    push(virtualMachine.ra);
                    break;
                case SVMParser.STORERV : //
                    virtualMachine.rv=pop();
                    break;
                case SVMParser.LOADRV : //
                    push(virtualMachine.rv);
                    break;
                case SVMParser.LOADFP : //
                    push(virtualMachine.fp);
                    break;
                case SVMParser.STOREFP : //
                    virtualMachine.fp=pop();
                    break;
                case SVMParser.COPYFP : //
                    virtualMachine.fp=virtualMachine.sp;
                    break;
                case SVMParser.STOREHP : //
                    virtualMachine.hp=pop();
                    break;
                case SVMParser.LOADHP : //
                    push(virtualMachine.hp);
                    break;
                case SVMParser.PRINT :
                    System.out.println((virtualMachine.sp<virtualMachine.MEMSIZE)?virtualMachine.memory[virtualMachine.sp]:"Empty stack!");
                    break;
                case SVMParser.HALT :
                    return;

            }
        }
    }

    private int pop() {
        return virtualMachine.memory[virtualMachine.sp++];
    }

    private void push(int v) {
        virtualMachine.memory[--virtualMachine.sp] = v;
    }

}