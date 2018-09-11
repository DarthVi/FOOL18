package unitTestCovella;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import org.junit.Before;
import org.junit.Test;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class TestSemantics
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

    @Test
    public void testUndeclaredVariable()
    {
        try
        {
            root = compiler.buildAST("let int pippo; in paperino + 2;");
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            assertEquals(1, e.errors.size());
            assertEquals("1:18 undeclared variable <paperino>", e.errors.get(0).msg);
        }
    }
}
