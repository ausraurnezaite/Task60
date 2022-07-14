package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    WebDriver driver;
    @FindBy(xpath = "//span[text() = 'Log in']")
    WebElement logInOption;
    @FindBy(xpath = "//span[text() = 'Create an account']")
    WebElement createAccountOption;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedOut() {
        return logInOption.isDisplayed() && createAccountOption.isDisplayed();
    }

}