package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.testng.Assert;
import org.testng.annotations.*;

public class LogInTest {

    @Parameters({"username", "password"})
    @Test
    public void testLogIn(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        HomePage homePage = new HomePage();
        homePage.load();
        LogInPage logInPage = homePage.logIn(username, password);

        Assert.assertTrue(logInPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(logInPage.isComposeButtonEnabled(), "compose button is not enabled");
        Assert.assertEquals(logInPage.getAccountName(), username, "users account name is not displayed correctly");
        homePage.close();
    }
}
