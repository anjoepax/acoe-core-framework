package org.acoe.com.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportsDemo {

    @Test
    public void test1() throws IOException {
        //Setup
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Selenium Automation");

        //Create Test
        ExtentTest test = extent.createTest("First Test");
        test.pass("Checking the logs");

        ExtentTest test1 = extent.createTest("Second Test");
        test1.pass("Checking the logs in the second test");

        //TearDown
        extent.flush();
        Desktop.getDesktop().browse(new File("index.html").toURI());
    }
}
