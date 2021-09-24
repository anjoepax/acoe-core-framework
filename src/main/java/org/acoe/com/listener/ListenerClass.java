package org.acoe.com.listener;

import lombok.SneakyThrows;
import org.acoe.com.annotations.FrameworkAnnotations;
import org.acoe.com.reports.ExtentLogger;
import org.acoe.com.reports.ExtentReport;
import org.testng.*;
import java.util.Arrays;

/**
 * Listener class that execute first before executing all the test inside the test suite
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class ListenerClass implements ITestListener, ISuiteListener {

    /**
     * Execute before executing the @BeforeSuite
     * @see org.testng.annotations.BeforeSuite
     * @param suite - test suite in testng.xml
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    /**
     * Execute after executing the @AfterSuite
     * @see org.testng.annotations.AfterSuite
     * @param suite - test suite in testng.xml
     */
    @Override
    @SneakyThrows
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    /**
     * Execute before executing the @Test
     * @see org.testng.annotations.Test
     * @param result - test method
     */
    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());

        ExtentReport.addAuthors(result.getMethod()
                .getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotations.class)
                .author());

        ExtentReport.addCategories(result.getMethod()
                .getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotations.class)
                .category());
    }

    /**
     * Execute after executing the passed @Test
     * @see org.testng.annotations.Test
     * @param result - test method
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    /**
     * Execute after executing the failed @Test
     * @see org.testng.annotations.Test
     * @param result - test method
     */
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    /**
     * Execute after executing the skipped @Test
     * @see org.testng.annotations.Test
     * @param result - test method
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /***
         * For now, we are not using this.
         */
    }

    @Override
    public void onStart(ITestContext context) {
        /***
         * We are having just one test in our test suite. So we do not have any special implementation as of now
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /***
         * We are having just one test in our test suite. So we do not have any special implementation as of now
         */
    }
}
