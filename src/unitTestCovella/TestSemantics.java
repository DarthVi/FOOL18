package unitTestCovella;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.junit.Before;
import org.junit.Test;
import type.IType;
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

    @Test
    public void testUndefinedFunction()
    {
        try
        {
            root = compiler.buildAST("let int pippo; in paperino();");
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        }
        catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            assertEquals(1, e.errors.size());
            assertEquals("1:18 call to undefined function <paperino>", e.errors.get(0).msg);
        }
    }

    @Test
    public void testUndeclaredVariableAssignment()
    {
        try
        {
            root = compiler.buildAST("let int pippo; in paperino = 2;");
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

    @Test
    public void testVariableReferenceInExp()
    {
        try
        {
            root = compiler.buildAST("let int pippo; int paperino; in paperino + pippo;");
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        }
    }

    @Test
    public void testVariableReferenceInStat()
    {
        try
        {
            root = compiler.buildAST("let " +
                    "int pippo = 1; int paperino = 3; int paperoga; " +
                    "in paperino = pippo; paperoga = paperino;");
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testFunctionDefinitionAndCallSemantics()
    {
        String code = "let" +
                "   int foo(int a) let bool flag; in a + 2;" +
                "   int c;" +
                "in" +
                "   foo(2);";

        try
        {
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        } catch (TypeException e)
        {
            fail("TypeException thrown without type errors");
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testMutualRecursionSemantics()
    {
        String code = "let" +
                "   int foo() g();" +
                "   int g() foo();" +
                "in" +
                "   foo();";

        try
        {
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        }
    }

    @Test
    public void functionCallWrongArgumentsTypecheck()
    {
        String code = "let\n" +
                "   int foo(int a) a + 2;\n" +
                "   bool c = false;\n" +
                "in\n" +
                "   foo(c);";

        try
        {
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("Incorrect exception thrown, should be TypeException");
        } catch (TypeException e)
        {
            assertEquals("Type error: \"Argument 1 has an incorrect type.\" at line 5, column 3.",
                    e.getMessage());
        }
    }

    @Test
    public void functionCallWrongArgumentSize()
    {
        String code = "let\n" +
                "   int foo(int a, int b) a + 2;\n" +
                "   int c = 1;\n" +
                "in\n" +
                "   foo(c);";

        try
        {
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("Incorrect exception thrown, should be TypeException");
        } catch (TypeException e)
        {
            assertEquals("Type error: \"Wrong number of arguments.\" at line 5, column 3.",
                    e.getMessage());
        }
    }

    //TODO: testare lo shadowing

    @SuppressWarnings("Duplicates")
    @Test
    public void outerScopeVariableReferenceInFunctionDefinition()
    {
        String code = "let\n" +
                "   int x;\n" +
                "   int y;\n" +
                "   int pippo() let int p = 4; in y;\n" +
                "   int paperino() let int g = 5; in x;" +
                "in\n"+
                "   pippo();";
        try
        {
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        }
    }
}
