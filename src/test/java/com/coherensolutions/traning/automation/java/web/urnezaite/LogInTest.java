package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LogInTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void testLogIn(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();
        LogInPage logInPage = homePage.logIn(username, password);

        Assert.assertTrue(logInPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(logInPage.isComposeButtonEnabled(), "compose button is not enabled");
        Assert.assertEquals(logInPage.getAccountName(), username, "users account name is not displayed correctly");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
