package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogOutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Parameters({"username", "password"})
    @Test
    public void logOutTest(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {

        HomePage homePage = new HomePage(driver);
        homePage.load();
        LogInPage logInPage = homePage.logIn(username, password);
        LogOutPage logOutPage = logInPage.logOut();

        Assert.assertTrue(logOutPage.isLoggedOut(), "'log in' or 'create an account' button should be displayed after the log out");
        homePage.close();
    }
}