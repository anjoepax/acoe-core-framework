package org.acoe.com.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;
import org.acoe.com.utils.ScreenshotUtil;

/**
 * Extent logger class that responsible in logging the test steps in the extent report
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class ExtentLogger {

    private ExtentLogger() {}

    /**
     * Log method for pass steps
     * @param message - log message
     */
    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    /**
     * Log method for failed steps
     * @param message - log message
     */
    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    /**
     * Log method for skipped steps
     * @param message - log message
     */
    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    /**
     * Log method for pass steps with screenshots
     * @param message - log message
     * @param isScreenshotNeeded - boolean flagger to enable screenshot
     */
    public static void pass(String message, boolean isScreenshotNeeded) {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
            && isScreenshotNeeded) {
            ExtentManager.getExtentTest()
                    .pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
        }else {
            pass(message);
        }
    }

    /**
     * Log method for fail steps with screenshots
     * @param message - log message
     * @param isScreenshotNeeded - boolean flagger to enable screenshot
     */
    public static void fail(String message, boolean isScreenshotNeeded) {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest()
                    .fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
        }else {
            fail(message);
        }
    }

    /**
     * Log method for skipped steps with screenshots
     * @param message - log message
     * @param isScreenshotNeeded - boolean flagger to enable screenshot
     */
    public static void skip(String message, boolean isScreenshotNeeded) {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreenshotNeeded) {
            ExtentManager.getExtentTest()
                    .skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
        }else {
            skip(message);
        }
    }

}
