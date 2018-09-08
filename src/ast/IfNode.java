package ast;

import java.util.ArrayList;

import exception.TypeException;
import lib.FOOLlib;
import org.antlr.v4.runtime.ParserRuleContext;
import type.BoolType;
import type.IType;
import type.VoidType;
import util.Environment;
import util.SemanticError;


public class IfNode implements INode {

    private INode cond;
    private INode th;
    private INode el;
    ParserRuleContext ctx;

    public IfNode (INode c, INode t, INode e, ParserRuleContext ctx) {
        cond=c;
        th=t;
        el=e;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException {

        if(!cond.typeCheck().isSubtypeOf(new BoolType()))
            throw new TypeException("non-boolean condition", ctx);

        IType thType = th.typeCheck();
        IType elType = el.typeCheck();

        //if this holds, we are using if(condition) then {statements} else {statements}
        if(thType.isSubtypeOf(new VoidType()) && elType.isSubtypeOf(new VoidType()))
            return new VoidType();

        //if the previous case does not hold, then T1<:T' and T2<:T' and the return type should be T'
        //If T1<:T2 then we can return T2 and use it in variable of type T2 or type T' with T2<:T'
        //vice versa we return T1.
        if(thType.isSubtypeOf(elType))
            return elType;

        if(elType.isSubtypeOf(thType))
            return thType;

        throw new TypeException("Type error in then and else branches ", ctx);
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> errors = new ArrayList<>();
        errors.addAll(cond.checkSemantics(env));
        errors.addAll(th.checkSemantics(env));
        if (el != null) {
            errors.addAll(el.checkSemantics(env));
        }
        return errors;
    }

    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return cond.codeGeneration()+
                "push 1\n"+
                "beq "+ l1 +"\n"+
                el.codeGeneration()+
                "b " + l2 + "\n" +
                l1 + ":\n"+
                th.codeGeneration()+
                l2 + ":\n";
    }


}