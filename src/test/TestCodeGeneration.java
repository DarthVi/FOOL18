package test;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.junit.Before;
import org.junit.Test;
import util.SemanticError;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestCodeGeneration
{
    private INode root;
    ArrayList<SemanticError> errors;
    private MockCompilerSteps compiler;

    @Before
    public void setUp() throws Exception
    {
        this.compiler = new MockCompilerSteps();
        this.root = null;
        errors = null;
    }

    private String runFile(String filePath) throws IOException, LexerException, ParserException,
            SemanticException, TypeException {
        String code = MockCompilerSteps.getStringFromFile("src/test/sources/" + filePath);
        return run(code);
    }

    private String run(String code) throws LexerException, ParserException,
            SemanticException, TypeException {
        root = compiler.buildAST(code);
        errors = compiler.checkSemantics(root, compiler.getEnvironment());
        compiler.typeCheck(root);
        compiler.codeGeneration(root);
        return compiler.execute();
    }

    @Test
    public void testAddition(){
        try {
            assertEquals("8", run("4+4;"));
        } catch (LexerException | ParserException | TypeException | SemanticException e) {
            fail("Exception thrown with valid code");
        }
    }

    @Test
    public void testFactorial(){
        try {
            assertEquals("120", runFile("factorial.fool"));
        } catch (IOException | LexerException | ParserException | TypeException | SemanticException e) {
            fail("Exception thrown with valid code");
        }
    }

    @Test
    public void testFibonacci(){
        try {
            assertEquals("8", runFile("fibonacci.fool"));
        } catch (IOException | LexerException | ParserException | TypeException | SemanticException e) {
            fail("Exception thrown with valid code");
        }
    }
}
