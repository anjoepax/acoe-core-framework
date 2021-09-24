package org.acoe.com.test;

import org.acoe.com.driver.Driver;
import org.acoe.com.driver.DriverManager;
import org.acoe.com.enums.ConfigProperties;
import org.acoe.com.utils.PropertyUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Map;

public class BaseTest {

    protected BaseTest() { }

    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
        DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
    }

    @AfterMethod
    protected void tearDown(ITestResult result){
        Driver.quitDriver();
    }
}
