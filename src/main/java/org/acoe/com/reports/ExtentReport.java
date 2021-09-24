package org.acoe.com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.enums.CategoryType;
import java.awt.*;
import java.io.File;
import java.util.Objects;

/**
 * Extent report class manager the initialization and closing of the extent report
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class ExtentReport {

    private static ExtentReports extent;

    private ExtentReport() { }

    /**
     * Initialize method
     */
    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Test Automation Report");
            spark.config().setReportName("Automated Test Report");
        }
    }

    /**
     * Closing the report
     * @throws Exception
     */
    public static void flushReport() throws Exception {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.removeExtentTest();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    /**
     * Create a test entry in the report
     * @param testCaseName - the test case name
     */
    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(testCaseName));
    }

    /**
     * Appends the list of author who writes the test
     * @param authors - list of authors
     */
    public static void addAuthors(String[] authors) {
        for(String author: authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    /**
     * Appends the list of test category performs in the test
     * @param categoryType - list of categories
     */
    public static void addCategories(CategoryType[] categoryType) {
        for(CategoryType category : categoryType) {
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
