package junit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class SomeJunit4Test {
    /**
     * in jUnit4 there is no  such interface like 'IRetryAnalyzer'. But, we can set our own 'RULES' !!!
     *  -> by implementing class TestRule, that is why we use @Rule annotation and create instance of a class
     */

    @Rule
    public RetryRule retry = new RetryRule(3); //we set a number of retries of flaky tests

    @Test
    public void testJunit4_1() {
        Assert.assertFalse(true);
    }

    @Test
    public void testJunit4_2() {
        Assert.assertFalse(false);
    }
}
