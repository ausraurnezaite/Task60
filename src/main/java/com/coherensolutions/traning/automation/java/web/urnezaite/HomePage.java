package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage logIn(String username, String password) {
        driver.findElement(YandexConstants.LOGIN_OPTION).click();
        driver.findElement(YandexConstants.USERNAME_INPUT).sendKeys(username);
        driver.findElement(YandexConstants.LOGIN_BUTTON).click();
        driver.findElement(YandexConstants.PASSWORD_INPUT).sendKeys(password);
        driver.findElement(YandexConstants.LOGIN_BUTTON).click();
        return new LogInPage(driver);
    }
}