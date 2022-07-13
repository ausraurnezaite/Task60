package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver driver;
    public final By ACCOUNT_NAME = By.cssSelector("span.user-account__name");
    public final By INBOX = By.xpath("//span[text() = 'Inbox']");
    public final By COMPOSE_BUTTON = By.cssSelector("a[href='#compose']");
    public final By USER_OPTIONS_LOCATOR = By.cssSelector("a.user-account.user-account_left-name");
    public final By LOGOUT_BUTTON = By.xpath("//span[contains(text(),'Log out')]");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogOutPage logOut() {
        driver.findElement(USER_OPTIONS_LOCATOR).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return new LogOutPage(driver);
    }

    public boolean isAccountNameDisplayed() {
        return driver.findElement(ACCOUNT_NAME).isDisplayed();
    }

    public boolean isInboxDisplayed() {
        return driver.findElement(INBOX).isDisplayed();
    }

    public boolean isComposeButtonEnabled() {
        return driver.findElement(COMPOSE_BUTTON).isEnabled();
    }
}