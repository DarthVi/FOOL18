import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.*;
import type.IType;
import util.Environment;
import util.SemanticError;
import visitors.FOOLVisitorImpl;
import visitors.FunctionVisitor;
import visitors.SVMVisitor;
import vm.VirtualMachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import visitors.SVMVisitorImpl;


public class Main {

    public static void main(String[] args) {
        try {


            String fileName = "code.fool";
            CharStream input = CharStreams.fromFileName("src/" +fileName);


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

            FOOLVisitor<INode> visitor = new FOOLVisitorImpl();

            INode ast = (INode) visitor.visit(progContext);

            System.out.println("BEGIN SEMANTIC ANALYSIS...");
            ArrayList<SemanticError> errors = ast.checkSemantics(env);
            if (errors.size() > 0) throw new SemanticException(errors);
            System.out.println("...END SEMANTIC ANALYSIS\n");

            //TYPE CHECKING
            System.out.println("BEGIN TYPE CHECKING...");
            IType type = ast.typeCheck();
            System.out.println("Type checking: " + type.toString());
            System.out.println("...END TYPE CHECKING\n");

            //CODE GENERATION
            System.out.println("BEGIN CODE GENERATION...");
            String code = ast.codeGeneration();
            System.out.println(code);
            System.out.println("...END CODE GENERATION\n");

            BufferedWriter out = new BufferedWriter(new FileWriter("src/" + fileName +".asm"));
            out.write(code);
            out.close();

            //CODE EXECUTION
            CodePointCharStream isASM = (CodePointCharStream) CharStreams.fromFileName("src/" + fileName +".asm");
            SVMLexer lexerASM = new SVMLexer(isASM);

            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);
            SVMParser.CodeContext codeContext = parserASM.code();
            System.out.println(parserASM.code());

            SVMVisitor svmVisitor = new SVMVisitor();
            svmVisitor.visit(codeContext);

            VirtualMachine vm = new VirtualMachine(svmVisitor.getCode());
            System.out.println();
             vm.cpu();


        } catch (IOException | LexerException | ParserException | SemanticException | TypeException  e ) {
            System.out.println(e.getMessage());
        }

    }
}
