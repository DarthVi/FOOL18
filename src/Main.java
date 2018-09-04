import ast.INode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import parser.FOOLLexer;
import parser.FOOLParser;
import parser.FOOLVisitorImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {

            String fileName = "src/main.fool";
            CharStream input = CharStreams.fromFileName(fileName);

            //LEXER
            System.out.println("BEGIN LEXICAL ANALYSIS...");
            FOOLLexer lexer = new FOOLLexer(input);
            // if (lexer.lexicalErrors.size() > 0) throw new LexerException(lexer.lexicalErrors);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            for (int i = 0; i < tokens.getNumberOfOnChannelTokens(); i++) {
                Token token = tokens.get(i);
                System.out.println(token.getTokenIndex() + " " + token.getText());
            }
            System.out.println("...END LEXICAL ANALYSIS");

            //PARSER
            System.out.println("BEGIN SYNTAX ANALYSIS...");
            FOOLParser parser = new FOOLParser(tokens);
            FOOLParser.ProgContext progContext = parser.prog(); //in caso di errore solleva l'eccezione ed il programma termina
            if (parser.getNumberOfSyntaxErrors() > 0) System.out.println("Problem!");
            //   throw new ParserException("Errori rilevati: " + parser.getNumberOfSyntaxErrors() + "\n");
            System.out.println("...END SYNTAX ANALYSIS");

            //SEMANTIC
            System.out.println("BEGIN SEMANTIC ANALYSIS...\n");
            FOOLVisitorImpl visitor = new FOOLVisitorImpl();
            INode ast = (INode) visitor.visit(progContext);
            /*SymbolTable env = new SymbolTable();
            List<String> err = ast.checkSemantics(env);
            if (err.size() > 0) throw new SemanticException(err);*/
            System.out.println("\n...END SEMANTIC ANALYSIS");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
