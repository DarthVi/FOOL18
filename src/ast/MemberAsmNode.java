package ast;

import exception.InvalidMemberAccessException;
import exception.MissingMemberException;
import exception.TypeException;
import exception.UndeclaredVariableException;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.FOOLParser;
import type.ClassMember;
import type.ClassType;
import type.IType;
import type.VoidType;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class MemberAsmNode implements INode
{
    private String objectId;
    private String memberId;
    private INode exp;
    private ParserRuleContext ctx;
    private STentry entryObject = null;
    private STentry entryMember = null;
    private ClassMember effectiveMember = null;
    private int nestingLevel;
    private int objectNestingLevel;
    private int objectOffset;
    private int indexOfMember = -1;
    private int currentNestingLevel;

    public MemberAsmNode(String objectId, String memberId, INode exp, ParserRuleContext ctx)
    {
        this.memberId = memberId;
        this.objectId = objectId;
        this.exp = exp;
        this.ctx = ctx;
    }

    @Override
    public IType typeCheck() throws TypeException
    {
        if(!exp.typeCheck().isSubtypeOf(effectiveMember.getType()))
            throw new TypeException("assignment not allowed if rhs is not a subtype or the same tipe of lhs", ctx);

        return new VoidType();
    }

    @Override
    public String codeGeneration()
    {
        String s;

        String getAR="";
        for (int i=0; i<nestingLevel-objectNestingLevel; i++)  getAR+="lw\n";

        //TODO: controllare che basti avere l'offset dell'entry
        s = "push " + indexOfMember + "\n" + // pushing ID's offset
                "push " + objectOffset + "\n" +       // TODO: check if it works
                "lfp\n" + getAR +
                "add\n" +
                "lw\n" +
                exp.codeGeneration() + //carica sullo stack il valore nuovo da assegnare
                "mm\n"; //chiamo l'istruzione modify member
        return s;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {
        ArrayList<SemanticError> errors = new ArrayList<>();

        try
        {
            entryObject = env.getEntry(((FOOLParser.MemberasmContext) ctx).ID(0).getSymbol());

            if(entryObject.isNull())
                throw new InvalidMemberAccessException(((FOOLParser.MemberasmContext) ctx).ID(0).getSymbol(), 1);

            IType oType = entryObject.getType();

            if(!(oType instanceof ClassType))
                throw new InvalidMemberAccessException(((FOOLParser.MemberasmContext) ctx).ID(0).getSymbol(), 0);

            ClassType classType = (ClassType) oType;

            ClassMember cm = new ClassMember(memberId,  null, null);

            indexOfMember = classType.getDeclaredOrderMembers().indexOf(cm);

            effectiveMember = (ClassMember) classType.getClassMembers().get(memberId);

            if(indexOfMember == -1)
                throw new MissingMemberException(((FOOLParser.MemberasmContext) ctx).ID(0).getSymbol(),
                        memberId, classType.getClassName());

            this.nestingLevel = env.getNestingLevel();
            this.objectNestingLevel = entryObject.getNestingLevel();
            this.objectOffset = entryObject.getOffset();

            errors.addAll(exp.checkSemantics(env));

        }catch(UndeclaredVariableException
                | MissingMemberException
                | InvalidMemberAccessException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }

        return errors;
    }
}
