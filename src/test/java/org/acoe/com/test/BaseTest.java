package org.acoe.com.test;

import org.acoe.com.driver.Driver;
import org.acoe.com.driver.DriverManager;
import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() { }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver(PropertyUtils.get(ConfigProperties.BROWSER));
        DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
    }

    @AfterMethod
    protected void tearDown(ITestResult result){
        Driver.quitDriver();
    }
}
