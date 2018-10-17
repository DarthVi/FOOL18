package unitTestCodeGen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

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
        else if (result != 100) fail("The result is wrong! \n" +
                "the result had to be 100 but it is " + result );
    }

    @Test
    public void test8()  {

        int result = compiler.main(  "test8.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 27) fail("The result is wrong! \n" +
                "the result had to be 27 but it is " + result );
    }

    @Test
    public void test9()  {

        int result = compiler.main(  "test9.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 3) fail("The result is wrong! \n" +
                "the result had to be 3 but it is " + result );
    }

    @Test
    public void test10()  {

        int result = compiler.main(  "test10.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 4) fail("The result is wrong! \n" +
                "the result had to be 4 but it is " + result );
    }

    @Test
    public void test11()  {

        int result = compiler.main(  "test11.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 53) fail("The result is wrong! \n" +
                "the result had to be 53 but it is " + result );
    }

    @Test
    public void test12()  {

        int result = compiler.main(  "test12.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 1012) fail("The result is wrong! \n" +
                "the result had to be 1012 but it is " + result );
    }

    @Test
    public void test13()  {

        int result = compiler.main(  "test13.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 6) fail("The result is wrong! \n" +
                "the result had to be 6 but it is " + result );
    }

    @Test
    public void test14()  {

        int result = compiler.main(  "test14.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 0) fail("The result is wrong! \n" +
                "the result had to be 0 but it is " + result );
    }

    @Test
    public void test15()  {

        int result = compiler.main(  "test15.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 13) fail("The result is wrong! \n" +
                "the result had to be 13 but it is " + result );
    }

    @Test
    public void test16()  {

        int result = compiler.main(  "test16.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 19) fail("The result is wrong! \n" +
                "the result had to be 19 but it is " + result );
    }

    @Test
    public void test17()  {

        int result = compiler.main(  "test17.fool");
        if(result == -100) fail ("CPU error");
        else if (result != -10) fail("The result is wrong! \n" +
                "the result had to be -10 but it is " + result );
    }

    @Test
    public void test18()  {

        int result = compiler.main(  "test18.fool");
        if(result == -100) fail ("CPU error");
        else if (result != -15) fail("The result is wrong! \n" +
                "the result had to be -15 but it is " + result );
    }

    @Test
    public void test19()  {

        int result = compiler.main(  "test19.fool");
        if(result == -100) fail ("CPU error");
        else if (result != -5) fail("The result is wrong! \n" +
                "the result had to be -5 but it is " + result );
    }

    @Test
    public void test20()  {

        int result = compiler.main(  "test20.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 5) fail("The result is wrong! \n" +
                "the result had to be 5 but it is " + result );
    }

    @Test
    public void test001()  {

        int result = compiler.main(  "test001.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 42) fail("The result is wrong! \n" +
                "the result had to be 42 but it is " + result );
    }

    @Test
    public void test002()  {

        int result = compiler.main(  "test002.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 7) fail("The result is wrong! \n" +
                "the result had to be 7 but it is " + result );
    }

    @Test
    public void testClass()  {

        int result = compiler.main(  "testClass.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 16) fail("The result is wrong! \n" +
                "the result had to be 16 but it is " + result );
    }

    @Test
    public void testClass2()  {

        int result = compiler.main(  "testClass2.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 37) fail("The result is wrong! \n" +
                "the result had to be 37 but it is " + result );
    }

    @Test
    public void testClass3()  {

        int result = compiler.main(  "testClass3.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 30) fail("The result is wrong! \n" +
                "the result had to be 30 but it is " + result );
    }

    @Test
    public void testClass4()  {
        //TODO check
        int result = compiler.main(  "testClass4.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 72) fail("The result is wrong! \n" +
                "the result had to be 72 but it is " + result );
    }

    @Test
    public void testClass5()  {

        int result = compiler.main(  "testClass5.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 72) fail("The result is wrong! \n" +
                "the result had to be 72 but it is " + result );
    }

    @Test
    public void testClass6()  {

        int result = compiler.main(  "testClass6.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 3) fail("The result is wrong! \n" +
                "the result had to be 3 but it is " + result );
    }

    @Test
    public void testClass7()  {

        int result = compiler.main(  "testClass7.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 15) fail("The result is wrong! \n" +
                "the result had to be 15 but it is " + result );
    }

    @Test
    public void testClass8()  {

        int result = compiler.main(  "testClass8.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 5) fail("The result is wrong! \n" +
                "the result had to be 5 but it is " + result );
    }

    @Test
    public void testClass9()  {

        int result = compiler.main(  "testClass9.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 120) fail("The result is wrong! \n" +
                "the result had to be 120 but it is " + result );
    }

    @Test
    public void testClass10()  {

        int result = compiler.main(  "testClass10.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 120) fail("The result is wrong! \n" +
                "the result had to be 120 but it is " + result );
    }

    @Test
    public void testClass11()  {

        int result = compiler.main(  "testClass11.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 14) fail("The result is wrong! \n" +
                "the result had to be 14 but it is " + result );
    }

    @Test
    public void testClass12()  {

        int result = compiler.main(  "testClass12.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 1860) fail("The result is wrong! \n" +
                "the result had to be 1860 but it is " + result );
    }

    @Test
    public void testClass13()  {

        int result = compiler.main(  "testClass13.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 21) fail("The result is wrong! \n" +
                "the result had to be 21 but it is " + result );
    }

    @Test
    public void testClass14()  {

        int result = compiler.main(  "testClass14.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 4) fail("The result is wrong! \n" +
                "the result had to be 4 but it is " + result );
    }

    @Test
    public void testClass15()  {

        int result = compiler.main(  "testClass15.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 5) fail("The result is wrong! \n" +
                "the result had to be 5 but it is " + result );
    }


    @Test
    public void ifTestClass1()  {

        int result = compiler.main(  "ifTestClass1.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 1) fail("The result is wrong! \n" +
                "the result had to be 1 but it is " + result );
    }

    @Test
    public void ifTestClass2()  {

        int result = compiler.main(  "ifTestClass2.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 15) fail("The result is wrong! \n" +
                "the result had to be 15 but it is " + result );
    }

    @Test
    public void ifTestClass3()  {

        int result = compiler.main(  "ifTestClass3.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 18) fail("The result is wrong! \n" +
                "the result had to be 18 but it is " + result );
    }

    @Test
    public void classTestPippo()  {

        int result = compiler.main(  "classTestPippo.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 2) fail("The result is wrong! \n" +
                "the result had to be 2 but it is " + result );
    }

    @Test
    public void classTestPippo2()  {

        int result = compiler.main(  "classTestPippo2.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 9) fail("The result is wrong! \n" +
                "the result had to be 9 but it is " + result );
    }

    @Test
    public void classTestPippo3()  {

        int result = compiler.main(  "classTestPippo3.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 3) fail("The result is wrong! \n" +
                "the result had to be 3 but it is " + result );
    }

    @Test
    public void classTestPippo4()  {

        int result = compiler.main(  "classTestPippo4.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 8) fail("The result is wrong! \n" +
                "the result had to be 8 but it is " + result );
    }

    @Test
    public void classTestPippo5()  {

        int result = compiler.main(  "classTestPippo5.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 42) fail("The result is wrong! \n" +
                "the result had to be 42 but it is " + result );
    }

    @Test
    public void classAsClassMember()  {

        int result = compiler.main(  "classAsClassMember.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 12) fail("The result is wrong! \n" +
                "the result had to be 12 but it is " + result );
    }

    @Test
    public void classDispatchingTest()  {

        int result = compiler.main(  "classDispatchingTest.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 6) fail("The result is wrong! \n" +
                "the result had to be 6 but it is " + result );
    }

    @Test
    public void classDispatchingTestOrder2()  {

        int result = compiler.main(  "classDispatchingTestOrder2.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 129) fail("The result is wrong! \n" +
                "the result had to be 129 but it is " + result );
    }

    @Test
    public void classForwardReferenceBetweenClasses()  {

        int result = compiler.main(  "classForwardReferenceBetweenClasses.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 15) fail("The result is wrong! \n" +
                "the result had to be 15 but it is " + result );
    }

    @Test
    public void classMutualRecursionBetweenClasses()  {

        int result = compiler.main(  "classMutualRecursionBetweenClasses.fool");
        if(result == -100) fail ("CPU error");
        else if (result != -68) fail("The result is wrong! \n" +
                "the result had to be -68 but it is " + result );
    }

    @Test
    public void classOrderOverriding()  {

        int result = compiler.main(  "classOrderOverriding.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 6) fail("The result is wrong! \n" +
                "the result had to be 6 but it is " + result );
    }

    @Test
    public void classTest()  {

        int result = compiler.main(  "classTest.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 10) fail("The result is wrong! \n" +
                "the result had to be 10 but it is " + result );
    }

    @Test
    public void classTest5()  {

        int result = compiler.main(  "classTest5.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 11) fail("The result is wrong! \n" +
                "the result had to be 11 but it is " + result );
    }

    @Test
    public void classTestClassAsArgument()  {

        int result = compiler.main(  "classTestClassAsArgument.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 5) fail("The result is wrong! \n" +
                "the result had to be 5 but it is " + result );
    }

    @Test
    public void classTestClassAsMethodArg()  {

        int result = compiler.main(  "classTestClassAsMethodArg.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 8) fail("The result is wrong! \n" +
                "the result had to be 8 but it is " + result );
    }

    @Test
    public void classTestCond3()  {

        int result = compiler.main(  "classTestCond3.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 10) fail("The result is wrong! \n" +
                "the result had to be 10 but it is " + result );
    }

    @Test
    public void classTestNullConditional()  {

        int result = compiler.main(  "classTestNullConditional.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 40) fail("The result is wrong! \n" +
                "the result had to be 40 but it is " + result );
    }

    @Test
    public void classTestNullEqual()  {

        int result = compiler.main(  "classTestNullEqual.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 10) fail("The result is wrong! \n" +
                "the result had to be 10 but it is " + result );
    }

    @Test
    public void classTestOrderMember()  {

        int result = compiler.main(  "classTestOrderMember.fool");
        if(result == -100) fail ("CPU error");
        else if (result != 42) fail("The result is wrong! \n" +
                "the result had to be 42 but it is " + result );
    }










}
