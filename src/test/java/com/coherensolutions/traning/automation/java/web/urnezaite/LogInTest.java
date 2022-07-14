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
    public void testLogIn(@Optional("selenium.test.account") String username, @Optional("SeleniumTestAccount") String password) {
        HomePage homePage = new HomePage(driver);
        homePage.load();

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshots/homePage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LogInPage logInPage = homePage.chooseLogInOption();
        InboxPage inboxPage = logInPage.logIn(username, password);

        Assert.assertTrue(inboxPage.isInboxDisplayed(), "inbox icon is not displayed");
        Assert.assertTrue(inboxPage.isComposeButtonEnabled(), "compose button is not enabled");
        Assert.assertEquals(inboxPage.getAccountName(), username, "users account name is not displayed correctly");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
