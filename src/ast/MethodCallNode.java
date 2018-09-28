package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import parser.FOOLParser;
import type.IType;

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
                + "push " + (methodOffset - 1) + "\n"   // carico l'offset del metodo rispetto all'inizio della dispatch table
                + "add" + "\n"                          // carico sullo stack dispatch_table_start + offset
                + "lc\n"                                // trovo l'indirizzo del metodo
                + "js\n";                               // salto all'istruzione dove e' definito il metodo e salvo $ra
    }


}
