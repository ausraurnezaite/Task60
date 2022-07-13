package com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    @FindBy(partialLinkText = "Log in")
    WebElement logInOption;
    @FindBy(partialLinkText = "Create an account")
    WebElement createAccountOption;

    public LogOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedOut() {
        return logInOption.isDisplayed() && createAccountOption.isDisplayed();
    }

}