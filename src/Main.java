import visitors.FOOLVisitorImpl;
import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import parser.FOOLLexer;
import parser.FOOLParser;
import parser.DebuggingVisitorImpl;
import type.IType;
import util.Environment;
import util.SemanticError;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {

            String fileName = "src/test/let_in.fool";
            CharStream input = CharStreams.fromFileName(fileName);

            //LEXER
            System.out.println("BEGIN LEXICAL ANALYSIS...");
            FOOLLexer lexer = new FOOLLexer(input);
            if (lexer.errors.size() > 0)
                throw new LexerException(lexer.errors);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            for (int i = 0; i < tokens.getNumberOfOnChannelTokens(); i++) {
                Token token = tokens.get(i);
                System.out.println(token.getTokenIndex() + " " + token.getText());
            }
            System.out.println("...END LEXICAL ANALYSIS\n");

            //PARSER
            System.out.println("BEGIN SYNTAX ANALYSIS...");
            FOOLParser parser = new FOOLParser(tokens);
            FOOLParser.ProgContext progContext = parser.prog();
            if (parser.getNumberOfSyntaxErrors() > 0)
                throw new ParserException("Errori rilevati: " + parser.getNumberOfSyntaxErrors() + "\n");
            System.out.println("...END SYNTAX ANALYSIS\n");

            //SEMANTIC
            System.out.println("BEGIN SEMANTIC ANALYSIS...\n");
            DebuggingVisitorImpl debuggingVisitor = new DebuggingVisitorImpl();
            INode debuggingAst = (INode) debuggingVisitor.visit(progContext);
            FOOLVisitorImpl visitor = new FOOLVisitorImpl();
            INode ast = visitor.visit(progContext);
            Environment env = new Environment();
            ArrayList<SemanticError> errors = ast.checkSemantics(env);
            System.out.println(ast.toString());
            if (errors.size() > 0)
                throw new SemanticException(errors);
            System.out.println("\n...END SEMANTIC ANALYSIS");

            //TYPE CHECKING
            System.out.println("BEGIN TYPE CHECKING...");
            IType type = ast.typeCheck();
            System.out.println("Type checking: " + type.toString());
            System.out.println("... END TYPE CHECKING...\n");

            //CODE GENERATION
            System.out.println("BEGIN CODE GENERATION...");
            String code = ast.codeGeneration();
            File svmFile = new File("code.svm");
            BufferedWriter svmWriter = new BufferedWriter(new FileWriter(svmFile.getAbsoluteFile()));
            svmWriter.write(code);
            svmWriter.close();
            System.out.println("END CODE GENERATION...\n");

        } catch (IOException | LexerException | ParserException | SemanticException | TypeException e) {
            System.out.println(e.getMessage());
        }
    }
}
