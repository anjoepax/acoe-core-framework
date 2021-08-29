package org.acoe.com.listener;

import lombok.SneakyThrows;
import org.acoe.com.reports.ExtentLogger;
import org.acoe.com.reports.ExtentReport;
import org.testng.*;

public final class ListenerClass implements ITestListener, ISuiteListener {

    @SneakyThrows
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @SneakyThrows
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
    }

    @SneakyThrows
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
