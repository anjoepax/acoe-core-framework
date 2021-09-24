package org.acoe.com.utils;

import org.acoe.com.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtil {

    private ScreenshotUtil() { }

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
