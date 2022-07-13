package com.coherensolutions.traning.automation.java.web.urnezaite;

import com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects.HomePage;
import com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects.LogInPage;
import com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects.LogOutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LogOutTest {
    WebDriver driver;
    String YANDEX_MAIL_LINK = "https://mail.yandex.com/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(YANDEX_MAIL_LINK);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Parameters({"username", "password"})
    @Test
    public void logOutTest(@Optional("selenium.test.account2") String username, @Optional("seleniumtestaccount2") String password) {

        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = homePage.logIn(username, password);
        LogOutPage logOutPage = logInPage.logOut();

        Assert.assertTrue(logOutPage.isLoggedOut(), "'log in' or 'create an account' button is not displayed after the log out");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}