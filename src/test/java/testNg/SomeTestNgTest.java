package testNg;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.Arrays;

public class SomeTestNgTest {

    /**
     *  IRetryAnalyzer interface is used to retry flaky test. We need simply override his method 'retry'
     */

    @BeforeSuite
    public void setUp(ITestContext context){
        //Using stream API we implement retry class to each test method
        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNgRetry.class));
    }

    @Test
    public void testNg1() {
        Assert.assertFalse(true);
    }

    @Test
    public void testNg2() {
        Assert.assertFalse(true);
    }

    @Test
    public void testNg3() {
        Assert.assertFalse(false);
    }
}
