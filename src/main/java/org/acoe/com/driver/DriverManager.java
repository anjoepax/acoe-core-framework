package org.acoe.com.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() { }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    public static synchronized void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    public static synchronized void unload() {
        driver.remove();
    }
}
