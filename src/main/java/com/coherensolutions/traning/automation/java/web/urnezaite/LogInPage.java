package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;
    @FindBy(css = "span.user-account__name")
    WebElement userAccountName;

    @FindBy(xpath = "//span[text() = 'Inbox']")
    WebElement inbox;

    @FindBy(css = "a[href='#compose']")
    WebElement composeButton;

    @FindBy(css = "a.user-account.user-account_left-name")
    WebElement userOptions;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    WebElement logOutButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogOutPage logOut() {
        userOptions.click();
        logOutButton.click();
        return new LogOutPage(driver);
    }

    public boolean isInboxDisplayed() {
        return inbox.isDisplayed();
    }

    public boolean isComposeButtonEnabled() {
        return composeButton.isEnabled();
    }

    public String getAccountName() {
        return userAccountName.getText();
    }
}