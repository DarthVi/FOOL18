package unitTestCovella;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.junit.Before;
import org.junit.Test;
import type.ClassType;
import type.IType;
import util.SemanticError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.instanceOf;

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

    @Test
    public void testVariableReferenceInStatWithTypechecking()
    {
        try
        {
            root = compiler.buildAST("let\n" +
                    "int x = 1; int y = 2\n;" +
                    "in y = x;");
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
            fail("TypeException thrown with valid code");
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testFunctionDefinitionAndCallSemantics()
    {
        String code = "let\n" +
                "   int foo(int a) let bool flag; in a + 2;\n" +
                "   int c;\n" +
                "in\n" +
                "   foo(2);\n";

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

    @Test
    public void simpleCorrectClassdec()
    {
        String filePath = "src/unitTestCovella/classTest1.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        } catch (IOException e)
        {
            fail("File opening failed");
        } catch (LexerException e)
        {
            fail("Lexer error with valid code");
        } catch (TypeException e)
        {
            fail("Type error with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException with valid code");
        } catch (ParserException e)
        {
            fail("ParserException with valid code");
        }
    }

    @Test
    public void simpleParentChildClassdec()
    {
        String filePath = "src/unitTestCovella/classTest2.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        }
        catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            System.out.println(e.getMessage());
            fail("SemanticException thrown with valid code");
        } catch (TypeException e)
        {
            fail("TypeException thrown with valid code");
        } catch (IOException e)
        {
            fail("File opening failed");
        }
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void incorrect3ClassdecHierarchyMissingMember()
    {
        String filePath = "src/unitTestCovella/classTest3.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        }
        catch (LexerException | ParserException | TypeException | IOException e)
        {
            fail("Incorrect exception thrown");
        } catch (SemanticException e)
        {
            assertEquals(1, e.errors.size());
            assertEquals("16:6 missing member <portatili> in class: <Paperino>", e.errors.get(0).msg);
        }
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void testClassdecAccessToMembers()
    {
        String filePath = "src/unitTestCovella/classTest4.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        }
        catch (LexerException | ParserException | TypeException | IOException | SemanticException e)
        {
            fail("Exception thrown with valid code");
        }
    }

    @Test
    public void testIfClass1()
    {
        String filePath = "src/unitTestCovella/ifTestClass1.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        }catch(TypeException e)
        {
            assertEquals("Type error: \"Type error in then and else branches\" " +
                    "at line 24, column 4.", e.getMessage());
        }
        catch (Exception e)
        {
            fail("Wrong exception thrown");
        }

    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testIfClass2()
    {
        String filePath = "src/unitTestCovella/ifTestClass2.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);

            assertThat(type, instanceOf(ClassType.class));

            assertEquals("A", ((ClassType) type).getClassName());
        }
        catch (LexerException | ParserException | TypeException | IOException | SemanticException e)
        {
            fail("Exception thrown with valid code");
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testIfClass3()
    {
        String filePath = "src/unitTestCovella/ifTestClass3.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);

            assertThat(type, instanceOf(ClassType.class));

            assertEquals("A", ((ClassType) type).getClassName());
        }
        catch (LexerException | ParserException | TypeException | IOException | SemanticException e)
        {
            fail("Exception thrown with valid code");
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testIfClassWrongAssignment()
    {
        String filePath = "src/unitTestCovella/ifTestClassWrongAssignment.fool";

        try
        {
            String code = getStringFromFile(filePath);
            root = compiler.buildAST(code);
            errors = compiler.checkSemantics(root, compiler.getEnvironment());
            IType type = compiler.typeCheck(root);
        }catch(TypeException e)
        {
            assertEquals("Type error: \"assignment not allowed if rhs is not a subtype or the same tipe of lhs\" " +
                    "at line 48, column 4.", e.getMessage());
        }
        catch (Exception e)
        {
            fail("Wrong exception thrown");
        }

    }

    public String getStringFromFile(String path) throws IOException
    {
        StringBuilder sb = new StringBuilder(1024);

        InputStream is = new FileInputStream(path);
        Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
        int c = 0;
        while ((c = r.read()) != -1) {
            sb.append((char) c);
        }

        return sb.toString();
    }
}
