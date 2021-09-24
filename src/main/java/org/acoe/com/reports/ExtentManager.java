package org.acoe.com.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * Extent manager class that manages the ThreadLocal of the ExtentTest class for parallel safety
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class ExtentManager {

    private ExtentManager() {}

    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /**
     * Gets the current ExtentTest context
     * @return ExtentTest instance
     */
    static ExtentTest getExtentTest() {
        return test.get();
    }

    /**
     * Set the extent test class instance
     * @param t extent test instance
     */
    static void setExtentTest(ExtentTest t) {
        test.set(t);
    }

    /**
     * Remove the current extent test context in the thread
     */
    static void removeExtentTest() {
        test.remove();
    }
}
