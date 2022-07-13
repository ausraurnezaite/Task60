package com.coherensolutions.traning.automation.java.web.urnezaite;

import com.coherensolutions.traning.automation.java.web.urnezaite.YandexConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {

    WebDriver driver;
    public static final By CREATE_ACCOUNT_OPTION = By.partialLinkText("Create an account");
    public static final By LOGIN_OPTION = By.partialLinkText("Log in");


    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedOut() {
        return driver.findElement(LOGIN_OPTION).isDisplayed() && driver.findElement(CREATE_ACCOUNT_OPTION).isDisplayed();
    }
}