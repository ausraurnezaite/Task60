package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.testng.Assert;
import org.testng.annotations.*;

public class LogOutTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void logOutTest(@Optional("selenium.test.account") String username, @Optional("SeleniumTestAccount") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();
        LogInPage logInPage = homePage.chooseLogInOption();
        InboxPage inboxPage = logInPage.logIn(username, password);
        HomePage homePageAfterLoggingOut = inboxPage.logOut();

        Assert.assertTrue(homePageAfterLoggingOut.isLoggedOut(), "'log in' or 'create an account' button should be displayed after the log out");
    }
}