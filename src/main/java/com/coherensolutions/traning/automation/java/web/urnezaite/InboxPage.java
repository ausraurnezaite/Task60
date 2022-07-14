package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    private WebDriver driver;
    @FindBy(css = "span.user-account__name")
    private WebElement userAccountName;

    @FindBy(xpath = "//span[text() = 'Inbox']")
    private WebElement inbox;

    @FindBy(css = "a[href='#compose']")
    private WebElement composeButton;

    @FindBy(css = "a.user-account.user-account_left-name")
    private WebElement userOptions;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private WebElement logOutButton;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage logOut() {
        userOptions.click();
        logOutButton.click();
        return new HomePage(driver);
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