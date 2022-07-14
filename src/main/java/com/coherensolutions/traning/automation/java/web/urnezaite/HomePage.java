package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final String YANDEX_MAIL_LINK = "https://mail.yandex.com/";
    private WebDriver driver;

    @FindBy(partialLinkText = "Log in")
    private WebElement logInOption;
    @FindBy(xpath = "//span[text() = 'Create an account']")
    private WebElement createAccountOption;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(YANDEX_MAIL_LINK);
    }

    public LogInPage chooseLogInOption() {
        logInOption.click();
        return new LogInPage(driver);
    }

    public boolean isLoggedOut() {
        return logInOption.isDisplayed() && createAccountOption.isDisplayed();
    }
}