package junit5;

import org.junit.Assert;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SomeJunit5 {

    /**First approach:
     * For one test to be re-run several times we can use @RepeatedTest(№ of re-run).
     * So, this test will re-run set by you number of times
     */

//    @RepeatedTest(3)
//    public void testJunit5() {
//        Assert.assertFalse(false);
//    }

    /**Second approach:
     * Add plugin (org.gradle.test-retry' version '1.0.0') and dependency 'retry'
     *
     */
    
    @Test
    public void testJunit5_2() {
        Assert.assertFalse(true);
    }

    @Test
    public void testJunit5_3() {
        Assert.assertFalse(true);
    }
}
