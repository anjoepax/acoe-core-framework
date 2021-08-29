package org.acoe.com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {

    private Driver() { }

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

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
