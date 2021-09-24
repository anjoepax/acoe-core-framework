package org.acoe.com.pages;

import org.acoe.com.utils.DecodeUtils;
import org.openqa.selenium.By;
import org.acoe.com.enums.WaitStrategy;

/**
 * Practice page for practicing Page Object Model design in Framework
 * @date September 23, 2021
 * @author Anthony Joseph Manigos
 */
public final class OrangeHRMLoginPage extends BasePage {

    private final By txtBoxUsername = By.id("txtUsername");
    private final By txtBoxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By btnLogin = By.id("btnLogin");


    public OrangeHRMLoginPage enterUsername(String username) {
        type(username, txtBoxUsername, WaitStrategy.PRESENCE, "[Username Field]");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        typePassword(DecodeUtils.getDecodedString(password), txtBoxPassword, WaitStrategy.CLICKABLE, "[Password Field]");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(btnLogin, WaitStrategy.PRESENCE, "[Login Button]");
        return new OrangeHRMHomePage();
    }

    public String getPageTitle() {
        return getTitle();
    }
}
