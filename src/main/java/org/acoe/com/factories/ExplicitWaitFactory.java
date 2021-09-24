package org.acoe.com.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.acoe.com.constants.FrameworkConstants;
import org.acoe.com.driver.DriverManager;
import org.acoe.com.enums.WaitStrategy;

/**
 * Factory class for waiting strategy
 * September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() { }

    /**
     *
     * @param waitStrategy - enum for wait strategy
     * @param locator - the target locator in the BasePage class
     * @return - defaults to null
     * @see org.acoe.com.pages.BasePage
     * @see WaitStrategy
     */
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

    /**
     * Wait for the element to be invisible
     * @param locator - target locator in the BasePage class
     * @see org.acoe.com.pages.BasePage
     */
    public static void waitForElementToBeInvisible(By locator) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait for the element text to be equal to something
     * @param locator - target locator in the BasePage class
     * @param text - text to be waited in the element
     */
    public static void waitForElementTextToBe(By locator, String text) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(d -> DriverManager.getDriver().findElement(locator).getText().equals(text));
    }

    /**
     * Wait for the number of elements to be equal to a specific count
     * @param locator - target locator in the BasePage class
     * @param count - expected count
     */
    public static void waitForNumberOfElementsToBe(By locator, Integer count) {
        new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(d -> DriverManager.getDriver().findElements(locator).size() == count);
    }
}
