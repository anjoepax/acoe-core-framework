package org.acoe.com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

/**
 *
 * Driver class is responsible for invoking and closing the browsers.
 * <p>
 * It is also responsible for setting the driver variable to DriverManager class which
 * handles the thread safety for the webdriver instance.
 * </p>
 *
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public final class Driver {

    private Driver() { }

    /**
     * Call this method to invoke your browser
     * @param browser value will be passed from BaseTest. Values can be chrome, edge, and firefox
     */
    public static void initDriver(String browser) {
        if(browser.equalsIgnoreCase("edge")) {
            if(Objects.isNull(DriverManager.getDriver())){
                WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());
            }
        }else if(browser.equalsIgnoreCase("firefox")) {
            if(Objects.isNull(DriverManager.getDriver())){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
        }else {
            if(Objects.isNull(DriverManager.getDriver())){
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
            }
        }
    }


    /**
     * Call this method in the BaseTest class to close browser
     * @param
     */
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
