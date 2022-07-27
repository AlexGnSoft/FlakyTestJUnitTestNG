package testNg;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgRetry implements IRetryAnalyzer {
    /**
     *  IRetryAnalyzer interface is used to retry flaky test. We need simply override his method 'retry'
      */

    //Set counter - счетчик перезапусков упавших тестов
    private int counter = 0;
    private int maxCount = 3; //макс кол-во перезапусков упавшего теста

    /**
     * Переписали метод перезапуска упавших тестов.
     * Если true - тест будет повторно запущен.
     * Если false - тест не будет повторно запущен.
     *
     * ITestResult - это любой тестовый класс
     */

    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            if(counter<maxCount){
                counter++;
                return true;
            }
        }
        return false;
    }
}
