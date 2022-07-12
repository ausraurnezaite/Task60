package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;
    WebElement userIcon;
    WebElement mailIcon;
    WebElement composeButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.userIcon = driver.findElement(YandexConstants.USERNAME_LOCATOR);
        this.mailIcon = driver.findElement(YandexConstants.MAIL_ICON);
        this.composeButton = driver.findElement(YandexConstants.COMPOSE_BUTTON);
    }

    public LogOutPage logOut() {
        clickUsersOption();
        driver.findElement(YandexConstants.LOGOUT_BUTTON).click();
        return new LogOutPage(driver);
    }

    private void clickUsersOption() {
        driver.findElement(YandexConstants.USER_OPTIONS_LOCATOR).click();
    }
}