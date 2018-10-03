package testVainigli;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.TypeException;
import exception.SemanticException;
import unitTestCovella.MockCompilerSteps;
import unitTestCovella.TestSemantics;

import java.io.IOException;

public class TestCodeGeneration {

    public static void main(String[] args) {
        MockCompilerSteps compiler = new MockCompilerSteps();
        INode root = null;
        String filePath = "src/unitTestCovella/classTest1.fool";
        try {
            String code = TestSemantics.getStringFromFile(filePath);
            root = compiler.buildAST(code);
            compiler.checkSemantics(root, compiler.getEnvironment());
            compiler.typeCheck(root);
            String SVMCode = compiler.codeGeneration(root);
            System.out.println(SVMCode);
        } catch (LexerException |
                ParserException |
                TypeException |
                IOException |
                SemanticException e){
            e.printStackTrace();
        }
    }
}
