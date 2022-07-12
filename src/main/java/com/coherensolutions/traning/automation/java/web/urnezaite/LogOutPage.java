package com.coherensolutions.traning.automation.java.web.urnezaite;

import com.coherensolutions.traning.automation.java.web.urnezaite.YandexConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {

    WebDriver driver;
    WebElement logInOption;
    WebElement createAccountOption;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        this.logInOption = driver.findElement(YandexConstants.LOGIN_OPTION);
        this.createAccountOption = driver.findElement(YandexConstants.CREATE_ACCOUNT_OPTION);
    }

    public boolean isLoggedOut() {
        return logInOption.isDisplayed() && createAccountOption.isDisplayed();
    }

}