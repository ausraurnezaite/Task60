package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;
    @FindBy(css = "input[id='passp-field-login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement loginButton;

    @FindBy(css = "input#passp-field-passwd")
    private WebElement passwordInput;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public InboxPage logIn(String username, String password) {
        usernameInput.sendKeys(username);
        loginButton.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new InboxPage(driver);
    }
}