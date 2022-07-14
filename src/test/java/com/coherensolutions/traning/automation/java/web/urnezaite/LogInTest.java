package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class LogInTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Parameters({"username", "password"})
    @Test
    public void testLogIn(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("Screenshots/homePage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogInPage logInPage = homePage.logIn(username, password);

        Assert.assertTrue(logInPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(logInPage.isComposeButtonEnabled(), "compose button is not enabled");
        Assert.assertEquals(logInPage.getAccountName(), username, "users account name is not displayed correctly");
        homePage.close();
    }
}
