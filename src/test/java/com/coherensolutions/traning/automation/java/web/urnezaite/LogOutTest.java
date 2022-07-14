package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LogOutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void logOutTest(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();
        LogInPage logInPage = homePage.chooseLogInOption();
        InboxPage inboxPage = logInPage.logIn(username, password);
        HomePage homePageAfterLoggingOut = inboxPage.logOut();

        Assert.assertTrue(homePageAfterLoggingOut.isLoggedOut(), "'log in' or 'create an account' button should be displayed after the log out");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}