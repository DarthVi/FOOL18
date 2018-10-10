package test;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.junit.Before;
import org.junit.Test;
import type.IType;
import util.SemanticError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
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

    private void run(String filePath) throws IOException, LexerException, ParserException, SemanticException {
        String code = MockCompilerSteps.getStringFromFile("src/test/sources/" + filePath);
        root = compiler.buildAST(code);
        errors = compiler.checkSemantics(root, compiler.getEnvironment());
    }

    @Test
    public void testUndeclaredVariable()
    {
        try
        {
            run("undeclared_variable.fool");
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
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void testUndefinedFunction()
    {
        try
        {
            run("undefined_function.fool");
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
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void testUndeclaredVariableAssignment()
    {
        try
        {
            run("undeclared_variable_asgm.fool");
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
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void testVariableReferenceInExp()
    {
        try
        {
            run("variable_reference_in_exp.fool");
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        } catch (IOException e){
            fail();
        }
    }

    @Test
    public void testVariableReferenceInStat()
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
        } catch (IOException e){
            fail();
        }
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testMutualRecursionSemantics()
    {
        try
        {
            run("mutual_recursion.fool");
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
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
        } catch (IOException e){
            fail();
        }
    }

    //TODO: testare lo shadowing

    @SuppressWarnings("Duplicates")
    @Test
    public void outerScopeVariableReferenceInFunctionDefinition()
    {
        try
        {
            run("outer_scope_var_ref_in_fun_def.fool");
        } catch (LexerException e)
        {
            fail("LexerException thrown with valid code");
        } catch (ParserException e)
        {
            fail("ParserException thrown with valid code");
        } catch (SemanticException e)
        {
            fail("SemanticException thrown with valid code");
        } catch (IOException e){
            fail();
        }
    }

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
        catch (LexerException | ParserException | IOException e)
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
        catch (LexerException | ParserException | IOException | SemanticException e)
        {
            fail("Exception thrown with valid code");
        }
    }
}