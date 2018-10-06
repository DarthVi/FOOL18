package test;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.junit.Before;
import org.junit.Test;
import util.SemanticError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class TestTypeChecking
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

    private void run(String filePath) throws IOException, LexerException, ParserException,
            SemanticException, TypeException {
        String code = MockCompilerSteps.getStringFromFile("src/test/sources/" + filePath);
        root = compiler.buildAST(code);
        errors = compiler.checkSemantics(root, compiler.getEnvironment());
        compiler.typeCheck(root);
    }

    @Test
    public void testVariableReferenceInStatWithTypechecking()
    {
        try
        {
            run("variable_reference_in_stat.fool");
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
        } catch (IOException e){
            fail();
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testFunctionDefinitionAndCallSemantics()
    {
        try
        {
            run("function_definition_and_call.fool");
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
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void functionCallWrongArgumentsTypecheck()
    {
        try
        {
            run("function_call_wrong_argument_types.fool");
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
            assertEquals("Type error: \"Argument 1 has an incorrect type.\" at line 6, column 4.",
                    e.getMessage());
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void functionCallWrongArgumentSize()
    {
        try
        {
            run("function_call_wrong_arguments.fool");
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
            assertEquals("Type error: \"Wrong number of arguments.\" at line 6, column 4.",
                    e.getMessage());
        } catch (IOException e){
            fail();
        }
    }

    //TODO: testare lo shadowing

    @Test
    public void simpleCorrectClassdec()
    {
        try
        {
            run("class_declaration.fool");
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
        try
        {
            run("subclass_declaration.fool");
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
        try
        {
            run("subsubclass_wrong_declaration.fool");
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
        try
        {
            run("subsubclass_declaration.fool");
        }
        catch (LexerException | ParserException | TypeException | IOException | SemanticException e)
        {
            fail("Exception thrown with valid code");
        }
    }
}
