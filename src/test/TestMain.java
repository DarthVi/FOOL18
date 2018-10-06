package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestSemantics.class,
        TestTypeChecking.class
})

public class TestMain {

}
