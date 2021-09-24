package org.acoe.com.driver;

import org.openqa.selenium.WebDriver;

/**
 * Manage the driver threads for being thread safety.
 * <p>
 *  Responsible for executing the test in parallel without encountering null pointer exception
 * </p>
 *
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class DriverManager {

    private DriverManager() { }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Capture the current driver instance of the thread
     * @return - the current webdriver instance
     */
    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Sets what type of browser driver
     * @param driverRef - the driver reference
     */
    public static synchronized void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    /**
     * Unload the finished driver instance in the thread
     */
    public static synchronized void unload() {
        driver.remove();
    }
}
