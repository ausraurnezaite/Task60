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
    }

    @Parameters({"username", "password"})
    @Test
    public void logInTest(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        driver.get(YandexConstants.YANDEX_MAIL_LINK);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = homePage.logIn(username, password);

        Assert.assertEquals(logInPage.userIcon.getText(), username, "users logo has incorrect username");
        Assert.assertTrue(logInPage.mailIcon.isDisplayed(), "email icon is not displayed");
        Assert.assertTrue(logInPage.composeButton.isEnabled(), "compose button is not enabled");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}