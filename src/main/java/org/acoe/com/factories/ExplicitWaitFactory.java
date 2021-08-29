package org.acoe.com.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.driver.DriverManager;
import org.acoe.com.enums.WaitStrategy;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() { }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By locator) {
        WebElement element = null;
        if(waitStrategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.elementToBeClickable(locator));
        }else if(waitStrategy == WaitStrategy.PRESENCE){
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        }else if(waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(locator);
        }

        return element;
    }

    public static void waitForElementToBeInvisible(By locator) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForElementTextToBe(By locator, String text) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(d -> DriverManager.getDriver().findElement(locator).getText().equals(text));
    }

    public static void waitForNumberOfElementsToBe(By locator, Integer count) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(d -> DriverManager.getDriver().findElements(locator).size() == count);
    }
}
