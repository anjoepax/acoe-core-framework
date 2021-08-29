package org.acoe.com.test;

import org.assertj.core.api.Assertions;
import org.acoe.com.pages.OrangeHRMLoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest {

    private OrangeHRMLoginPage loginPage;

    private OrangeHRMTests() { }

    @BeforeMethod
    public void setUpPages() {
        loginPage = new OrangeHRMLoginPage();
    }

    @Test(dataProvider = "LoginTestData")
    public void loginLogoutTest(String username, String password) {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .logout();
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "LoginTestData", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin", "admin123"},
        };
    }
}

