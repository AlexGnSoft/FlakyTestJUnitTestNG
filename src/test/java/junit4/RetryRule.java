package junit4;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {

    /**
     * in jUnit4 there is no  such interface like 'IRetryAnalyzer'. But, we can set our own 'RULES' !!!
     *  -> by implementing class TestRule
     */

    //Set counter - счетчик перезапусков упавших тестов
    private int retryCounter = 0;

    public RetryRule(int retryCounter) {
        this.retryCounter = retryCounter;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable error = null;
                for (int i = 0; i < retryCounter; i++) {
                    try{
                        base.evaluate();
                        return;
                    }catch (Throwable t){
                        error = t;
                        System.err.println(description.getDisplayName() + " был запущен " + (i+1) + " раз ");
                    }
                }
                System.err.println(description.getDisplayName() + " тест упал после попыток " + retryCounter);
                throw error;
            }
        };
    }
}
