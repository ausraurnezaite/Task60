package com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;
    //    @FindBy(xpath = "//span[contains(@class, 'user-account')]")
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'user-account')]")
    WebElement userAccountIcon;

    //    @FindBy(xpath = "//div[contains(@class, 'PSHeaderIcon-Image_Mail')]")
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'PSHeaderIcon-Image_Mail')]")
    WebElement mailIcon;
    //    @FindBy(css = "a[href='#compose']")
    @FindBy(how = How.CSS, using = "a[href='#compose']")
    WebElement composeButton;

    @FindBy(css = "a.user-account.user-account_left-name")
    WebElement userOptions;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    WebElement logOutButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LogOutPage logOut() {
        userOptions.click();
        logOutButton.click();
        return PageFactory.initElements(driver, LogOutPage.class);
    }

    public String getUserAccountIconText() {
        return userAccountIcon.getText();
    }

    public boolean isMailIconDisplayed() {
        return mailIcon.isDisplayed();
    }

    public boolean isComposeButtonEnabled() {
        return composeButton.isEnabled();
    }
}