package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LogInTest {
    WebDriver driver;
    public final String YANDEX_MAIL_LINK = "https://mail.yandex.com/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(YANDEX_MAIL_LINK);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void testLogIn(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = homePage.logIn(username, password);

        Assert.assertTrue(logInPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(logInPage.isAccountNameDisplayed(), "users account name is not displayed");
        Assert.assertTrue(logInPage.isComposeButtonEnabled(), "compose button is not enabled");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}