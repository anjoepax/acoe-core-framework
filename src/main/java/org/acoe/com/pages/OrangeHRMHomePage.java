package org.acoe.com.pages;

import org.openqa.selenium.By;
import org.acoe.com.enums.WaitStrategy;

/**
 * Practice page for practicing Page Object Model design in Framework
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMLoginPage logout() {
        click(linkWelcome, WaitStrategy.CLICKABLE, "[Welcome Link]");
        click(linkLogout, WaitStrategy.CLICKABLE, "[Logout Link]");
        return new OrangeHRMLoginPage();
    }
}
