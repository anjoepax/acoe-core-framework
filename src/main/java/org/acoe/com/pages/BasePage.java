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

public class BasePage {

    protected BasePage() { }

    protected void click(By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked", true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void type(String text, By locator, WaitStrategy strategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text);
        try {
            ExtentLogger.pass(elementName + " is populated with " + "[" + text + "]", true);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void typeTextAndEnter(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

    protected void typeTextAndTab(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        element.clear();
        element.sendKeys(text, Keys.TAB);
    }

    protected void selectDropDownByText(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByVisibleText(text), element);
    }

    protected void selectDropDownByValue(String text, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByValue(text), element);
    }

    protected void selectDropDownByIndex(Integer index, By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        selectDropDown(e -> e.selectByIndex(index), element);
    }

    protected boolean isElementEnabled(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.isEnabled();
    }

    protected boolean isElementSelected(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.isSelected();
    }

    protected String getElementText(By locator, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getText();
    }

    protected String getElementAttribute(By locator, String attr, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getAttribute(attr);
    }

    protected String getElementCssValue(By locator, String cssProperty, WaitStrategy strategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(strategy, locator);
        return element.getCssValue(cssProperty);
    }

    protected void executeJavascript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    protected void executeJavascript(String script, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(locator);
        js.executeScript(script, element);
    }

    private void selectDropDown(Consumer<Select> select, WebElement element) {
        select.accept(new Select(element));
    }

    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void scrollElementInToView(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,-130)");
    }

    protected void clear(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.clear();
    }

}
