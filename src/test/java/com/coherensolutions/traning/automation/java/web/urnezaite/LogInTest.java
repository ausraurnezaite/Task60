package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.testng.Assert;
import org.testng.annotations.*;


public class LogInTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void testLogIn(@Optional("selenium.test.account") String username, @Optional("SeleniumTestAccount") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();

        LogInPage logInPage = homePage.chooseLogInOption();
        InboxPage inboxPage = logInPage.logIn(username, password);

        Assert.assertTrue(inboxPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(inboxPage.isComposeButtonEnabled(), "compose button is not enabled");
        Assert.assertEquals(inboxPage.getAccountName(), username, "users account name is not displayed correctly");
    }
}
