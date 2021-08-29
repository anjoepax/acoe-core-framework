package org.acoe.com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager() {}

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return test.get();
    }

    static void setExtentTest(ExtentTest t) {
        test.set(t);
    }

    static void removeExtentTest() {
        test.remove();
    }
}
