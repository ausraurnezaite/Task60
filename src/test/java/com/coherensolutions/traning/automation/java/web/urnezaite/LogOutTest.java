package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.testng.Assert;
import org.testng.annotations.*;

public class LogOutTest {

    @Parameters({"username", "password"})
    @Test
    public void logOutTest(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {

        HomePage homePage = new HomePage();
        homePage.load();
        LogInPage logInPage = homePage.logIn(username, password);
        LogOutPage logOutPage = logInPage.logOut();

        Assert.assertTrue(logOutPage.isLoggedOut(), "'log in' or 'create an account' button should be displayed after the log out");
        homePage.close();
    }
}