package org.acoe.com.pages;

import org.acoe.com.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.acoe.com.driver.DriverManager;
import org.acoe.com.enums.WaitStrategy;
import org.acoe.com.factories.ExplicitWaitFactory;
import java.util.function.Consumer;

/**
 * Basepage class where all common web element methods are placed here.
 * <p>
 *     All page object classes should extend this BasePage class
 * </p>
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public class BasePage {

    protected BasePage() { }

    /**
     * Clicks the target element using click method
     * @param locator - target element
     * @param strategy - wait strategy
     * @param elementName - element name for reporting
     */
    protected void click(By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.click();
        ExtentLogger.pass(elementName + " is clicked", true);
    }

    /**
     * Type text to the target element
     * @param text - text input
     * @param locator - target locator
     * @param strategy - wait strategy
     * @param elementName - element name for reporting
     */
    protected void type(String text, By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text);
        ExtentLogger.pass(elementName + " is populated with " + "[" + text + "]", true);
    }

    /**
     * Type a password to the target element
     * @param text - text input
     * @param locator - target locator
     * @param strategy - wait strategy
     * @param elementName - element name for reporting
     */
    protected void typePassword(String text, By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text);
        ExtentLogger.pass(elementName + " is populated with *******", true);
    }

    /**
     * Type text then press ENTER to the target element
     * @param text - text input
     * @param locator - target locator
     * @param strategy - wait strategy
     */
    protected void typeTextAndEnter(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

    /**
     * Type text the press TAB to the target element
     * @param text - text input
     * @param locator - target locator
     * @param strategy - wait strategy
     */
    protected void typeTextAndTab(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text, Keys.TAB);
    }

    /**
     * Select a dropdown option by text
     * @param text - the text option
     * @param locator - target locator
     * @param strategy - wait strategy
     */
    protected void selectDropDownByText(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByVisibleText(text), element);
    }

    /**
     * Select a dropdown option by value
     * @param text - the text value
     * @param locator - target locator
     * @param strategy - wait strategy
     */
    protected void selectDropDownByValue(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByValue(text), element);
    }

    /**
     * Select a dropdown option by index
     * @param index - the index option
     * @param locator - target locator
     * @param strategy - wait strategy
     */
    protected void selectDropDownByIndex(Integer index, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByIndex(index), element);
    }

    /**
     * Verify if element is enabled
     * @param locator - target locator
     * @param strategy - wait strategy
     * @return boolean value
     */
    protected boolean isElementEnabled(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.isEnabled();
    }

    /**
     * Verify if element is selected
     * @param locator - target locator
     * @param strategy - wait strategy
     * @return boolean value
     */
    protected boolean isElementSelected(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.isSelected();
    }

    /**
     * Get the text or the innerText of an element
     * @param locator - Target locator
     * @param strategy - wait strategy
     * @return String
     */
    protected String getElementText(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getText();
    }

    /**
     * Get the particular attribute of an element
     * @param locator - target locator
     * @param attr - attribute value
     * @param strategy - wait strategy
     * @return String
     */
    protected String getElementAttribute(By locator, String attr, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getAttribute(attr);
    }

    /**
     * Get the css value property of an element
     * @param locator - target locator
     * @param cssProperty - the css property
     * @param strategy - wait strategy
     * @return String
     */
    protected String getElementCssValue(By locator, String cssProperty, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getCssValue(cssProperty);
    }

    /**
     * Execute javascript code in the current browser context
     * @param script - the js code to be executed
     */
    protected void executeJavascript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    /**
     * Execute javascript code in the current browser context with args
     * @param script - the js code to be executed
     * @param locator - the target locator
     */
    protected void executeJavascript(String script, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(locator);
        js.executeScript(script, element);
    }

    private void selectDropDown(Consumer<Select> select, WebElement element) {
        select.accept(new Select(element));
    }

    /**
     * Get the current title of the browser
     * @return String
     */
    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Scrolls the element to the current view
     * @param locator - target locator
     */
    protected void scrollElementInToView(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,-130)");
    }

    /**
     * Clears the text content of an element
     * @param locator - target locator
     * @param waitStrategy - wait strategy
     */
    protected void clear(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.clear();
    }

}
