package org.acoe.com.test;

import org.acoe.com.annotations.FrameworkAnnotations;
import org.acoe.com.enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.acoe.com.pages.OrangeHRMLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMLoginPage loginPage;

    private OrangeHRMTests() { }

    @BeforeMethod
    public void setUpPages() {
        loginPage = new OrangeHRMLoginPage();
    }


    @FrameworkAnnotations(author = {"Anthony", "Joseph"}, category = {CategoryType.SMOKE, CategoryType.SANITY})
    @Test
    public void loginLogoutTest(Map<String, String> data) {
        loginPage.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .logout();
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("OrangeHRM");
    }


    @FrameworkAnnotations(author = {"Amuthan"}, category = {CategoryType.REGRESSION})
    @Test
    public void newTest(Map<String, String> data) {
        loginPage.enterUsername(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .logout();
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("OrangeHRM");
    }
}

