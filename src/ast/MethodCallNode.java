package ast;

import exception.NullPointerException;
import exception.TypeException;
import exception.UndeclaredClassException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.*;
import util.DTableEntry;
import util.Environment;
import util.STentry;
import util.SemanticError;

import java.util.ArrayList;

public class MethodCallNode  extends FunCallNode  {
    private int objectOffset;
    private int objectNestingLevel;
    private int methodOffset;
    private int nestinglevel;

    private String objectID;
    private String methodID;
    private IType methodType;

    public MethodCallNode(Token token, ActualParamsNode args, FOOLParser.ObjCallContext ctx, String objectID, String methodID) {
        super(token, args, ctx);
        this.objectID = objectID;
        this.methodID = methodID;


    }


    @Override
    public IType typeCheck() throws TypeException
    {
        FunctionType funType = (FunctionType) this.methodType;

        actualArgs.typeCheck();

        if(actualArgs.size() != funType.getArgumentListSize())
            throw new TypeException("Wrong number of arguments.", ctx);

        //we must check that the actual arguments are of the right type
        //(the one that follows the function declaration)
        for(int i = 0; i < actualArgs.size(); i++)
        {
            INode arg = actualArgs.get(i);

            if(!arg.typeCheck().isSubtypeOf(funType.getArgumentType(i)))
                throw new TypeException("Argument " + (i + 1) + " has an incorrect type.",ctx);
        }

        if (extra == 1 && !funType.getReturnType().isSubtypeOf(new IntType()))
        {

            throw new TypeException("- operator allowed only for int value", ctx);
        }

        if (extra == 2 && !funType.getReturnType().isSubtypeOf(new BoolType()))
        {
            throw new TypeException("not operator allowed only for bool value", ctx);
        }

            return funType.getReturnType();
    }

    //TODO: check this
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env)
    {


        ArrayList<SemanticError> errors = new ArrayList<>();

        nestinglevel = env.getNestingLevel();



        try
        {
            ClassType classType = null;

            if(objectID.equals("this"))
            {
                STentry thisEntry = env.getEntry(
                        ((FOOLParser.ObjCallContext) ctx).ID(0).getSymbol());

                objectOffset = 0;

                classType = (ClassType) thisEntry.getType();
                objectNestingLevel = 3;
            }
            else
            {
                STentry entry = env.getEntry(
                        ((FOOLParser.ObjCallContext) ctx).ID(0).getSymbol());

                if(entry.isNull())
                {
                    throw new NullPointerException(((FOOLParser.ObjCallContext) ctx).ID(0).getSymbol());
                }

                IType objectType = entry.getType();
                objectOffset = entry.getOffset();
                objectNestingLevel = entry.getNestingLevel();

                STentry check = env.checkEntryPresence("this");
                // controllo se c'è this, se c'è sono in un metodo e decremento il nesting level
                if(check != null)
                    nestinglevel--;

                if(! (objectType instanceof ClassType))
                {
                    errors.add(new SemanticError("Invocazione di metodo su un tipo non oggetto"));
                }
                else
                    classType = (ClassType) objectType;

                if(errors.size()>0) return errors;
            }


            STentry classEntry = env.getEntry(
                    ((FOOLParser.ObjCallContext) ctx).ID(0).getSymbol());

            //classname will be used to get the dispatch table index to retrieve the method offset
            String classname = classType.getClassName();
            ArrayList<DTableEntry> dtable = env.getDftTable(classname);

            methodOffset = 0;
            boolean found = false;
            //this loop is needed in order to find the method offset in the dispatch function
            //table
            for(int i = 0; i < dtable.size() && !found; i++)
            {
                DTableEntry dEntry = dtable.get(i);

                if(dEntry.getMethodId().equals(this.methodID))
                {
                    methodOffset = i;
                    found = true;
                }

            }

            System.out.println(classType.getClassMethods() + "  " + objectID);
            ClassMethod classMethod = ((ClassMethod) classType.getClassMethods().get(methodID));

            if(classMethod == null)
            {
                errors.add(new SemanticError("Object " + objectID + " doesn't have a " + methodID + " method."));
            }
            else
                methodType = classMethod.getMethodType();


            //checkSemantics of effective arguments
            actualArgs.checkSemantics(env);

        }
        catch (UndeclaredClassException |
                NullPointerException e)
        {
            errors.add(new SemanticError(e.getMessage()));
        }


        return errors;
    }

    @Override
    public String codeGeneration() {
        StringBuilder parCode = new StringBuilder();
        for (int i = actualArgs.size() - 1; i >= 0; i--)
            parCode.append(actualArgs.get(i).codeGeneration());

        StringBuilder getAR = new StringBuilder();

        for (int i = 0; i < nestinglevel - objectNestingLevel; i++)
            getAR.append("lw\n");

        return "lfp\n"                                  // carico il frame pointer
                + parCode                               // carico i parametri
                + "push " + objectOffset + "\n"         // carico l'offset dell'oggetto nello scope di definizione
                + "lfp\n"                               // carico il frame pointer
                + getAR                                 // faccio gli lw necessari fino a trovarmi sullo stack l'indirizzo in memoria del frame dove e' definito l'oggetto
                + "add\n"                               // faccio $fp + offset per ottenere l'indirizzo in memoria dell'oggetto
                + "lw\n"                                // carico il valore dell'oggetto sullo stack
                + "copy\n"                              // copio il valore sopra (l'indirizzo di memoria nel quale si trova l'indirizzo della dispatch table)
                + "lw\n"                                // carico l'indirizzo della dispatch table sullo stack
                + "push " + (methodOffset ) + "\n"   // carico l'offset del metodo rispetto all'inizio della dispatch table
                + "add" + "\n"                          // carico sullo stack dispatch_table_start + offset
                + "lc\n"                                // trovo l'indirizzo del metodo
                + "js\n";                               // salto all'istruzione dove e' definito il metodo e salvo $ra
    }


}
