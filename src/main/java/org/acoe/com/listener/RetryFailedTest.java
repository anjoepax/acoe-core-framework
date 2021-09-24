package org.acoe.com.listener;

import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry listener that retries a failed test for 2 times
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;

    /**
     * Retry method responsible in retrying the failed test
     * @param iTestResult - the result of the test
     * @return - returns boolean
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
            int retries = 1;
            value = count < retries;
            count++;
        }
        return value;
    }
}
