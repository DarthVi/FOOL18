import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.ExecuteVM;
import parser.FOOLLexer;
import parser.FOOLParser;
import parser.SVMLexer;
import parser.SVMParser;
import util.Environment;
import util.SemanticError;
import ast.FOOLVisitorImpl;
import ast.INode;

public class Test {
    public static void main(String[] args) throws Exception {

        String fileName = "main.fool";

        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FOOLParser parser = new FOOLParser(tokens);

            FOOLVisitorImpl visitor = new FOOLVisitorImpl();

            INode ast = visitor.visit(parser.prog()); //generazione AST

                // CODE GENERATION  main.fool.asm
                String code=ast.codeGeneration();
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
                out.write(code);
                out.close();
                System.out.println("Code generated! Assembling and running generated code.");

                FileInputStream isASM = new FileInputStream(fileName+".asm");
                ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                SVMLexer lexerASM = new SVMLexer(inputASM);
                CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                SVMParser parserASM = new SVMParser(tokensASM);

                parserASM.assembly();

                System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
                if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

                System.out.println("Starting Virtual Machine...");
                ExecuteVM vm = new ExecuteVM(parserASM.code);
                vm.cpu();
            }

}
