package unitTestCodeGen;

import ast.INode;
import exception.LexerException;
import exception.ParserException;
import exception.SemanticException;
import exception.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Before;
import org.junit.Test;
import type.ClassType;
import type.IType;
import unitTestCovella.MockCompilerSteps;
import util.SemanticError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TestCodeGeneration {
    private MockCompilerStepsCodeGen compiler;

    @Before
    public void setUp() throws Exception {
        this.compiler = new MockCompilerStepsCodeGen();
    }

    @Test
    public void test()  {

        int result = compiler.main(  "test.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 2) fail("The result is wrong! \n" +
                "the result had to be 2 but it is " + result );
    }

    @Test
    public void test1()  {

        int result = compiler.main(  "test1.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 120) fail("The result is wrong! \n" +
                "the result had to be 120 but it is " + result );
    }

    @Test
    public void test2()  {

        int result = compiler.main(  "test2.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 10) fail("The result is wrong! \n" +
                "the result had to be 10 but it is " + result );
    }

    @Test
    public void test3()  {

        int result = compiler.main(  "test3.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 16) fail("The result is wrong! \n" +
                "the result had to be 16 but it is " + result );
    }

    @Test
    public void test4()  {

        int result = compiler.main(  "test4.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 42) fail("The result is wrong! \n" +
                "the result had to be 42 but it is " + result );
    }

    @Test
    public void test5()  {

        int result = compiler.main(  "test5.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 35) fail("The result is wrong! \n" +
                "the result had to be 35 but it is " + result );
    }

    @Test
    public void test6()  {

        int result = compiler.main(  "test6.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 1) fail("The result is wrong! \n" +
                "the result had to be 1 but it is " + result );
    }

    @Test
    public void test7()  {

        int result = compiler.main(  "test7.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 1001) fail("The result is wrong! \n" +
                "the result had to be 1001 but it is " + result );
    }


}
