package TestMassimiliani;

import visitors.FunctionVisitor;
import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.FOOLLexer;
import parser.FOOLParser;
import parser.SVMLexer;
import parser.SVMParser;
import type.IType;
import util.Environment;
import util.SemanticError;
import vm.ExecuteVM;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import visitors.FOOLVisitorImpl;


public class Main {

    public static void main(String[] args) {
        try {

            String fileName = "TestMassimiliani/test.fool";
            CharStream input = CharStreams.fromFileName(fileName);

            //LEXER
            FOOLLexer lexer = new FOOLLexer(input);
            if (lexer.errors.size() > 0)
                throw new LexerException(lexer.errors);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //PARSING - Syntax analysis
            FOOLParser parser = new FOOLParser(tokens);
            FOOLParser.ProgContext progContext = parser.prog();
            if (parser.getNumberOfSyntaxErrors() > 0)
                throw new ParserException("Errori rilevati: " + parser.getNumberOfSyntaxErrors() + "\n");


            FunctionVisitor funVisitor = new FunctionVisitor();

            funVisitor.visit(progContext);

            //we do a little bit of semantic analysis even here, considering however
            //only function definitions
            if(funVisitor.getErrorsSize() > 0)
                throw new SemanticException(funVisitor.getErrors());

            Environment env = funVisitor.getEnvironment();



            FOOLVisitorImpl visitor = new FOOLVisitorImpl();

            INode ast = (INode) visitor.visit(progContext);


            ArrayList<SemanticError> errors = ast.checkSemantics(env);
            if (errors.size() > 0) throw new SemanticException(errors);
            System.out.println("\n...END SEMANTIC ANALYSIS");

            //TYPE CHECKING
            System.out.println("BEGIN TYPE CHECKING...");
            IType type = ast.typeCheck();
            System.out.println("Type checking: " + type.toString());
            System.out.println("... END TYPE CHECKING...\n");

            //CODE GENERATION
            System.out.println("BEGIN CODE GENERATION...");
            String code = ast.codeGeneration();
            code += "halt";                                            //to stop execution
            System.out.println(code);
            System.out.println("END CODE GENERATION...\n");

            BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));

            out.write(code);
            out.close();

            //CODE EXECUTION
            CharStream isASM = CharStreams.fromFileName(fileName+".asm");
            SVMLexer lexerASM = new SVMLexer( isASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);
            parserASM.assembly();

            ExecuteVM vm = new ExecuteVM(parserASM.code);
            System.out.println();
            vm.cpu();


        } catch (IOException | LexerException | ParserException | SemanticException | TypeException  e ) {
            System.out.println(e.getMessage());
        }

    }
}