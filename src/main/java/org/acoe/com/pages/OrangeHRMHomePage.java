package org.acoe.com.pages;

import org.openqa.selenium.By;
import org.acoe.com.enums.WaitStrategy;


public final class OrangeHRMHomePage extends BasePage {

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMLoginPage logout() {
        click(linkWelcome, WaitStrategy.CLICKABLE, "[Welcome Link]");
        click(linkLogout, WaitStrategy.CLICKABLE, "[Logout Link]");
        return new OrangeHRMLoginPage();
    }
}
