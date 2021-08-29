package org.acoe.com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.acoe.com.constants.FrameworkConstants;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() { }

    public static void initReports() throws Exception {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Test Automation Report");
            spark.config().setReportName("Automated Test Report");
        }
    }

    public static void flushReport() throws Exception {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }
}
