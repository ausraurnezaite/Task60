package com.coherensolutions.traning.automation.java.web.urnezaite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    final String TITLE = "Yandex.Mail — free, reliable email";
    @FindBy(partialLinkText = "Log in")
    WebElement loginOption;

    @FindBy(css = "input[id='passp-field-login']")
    WebElement usernameInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    WebElement loginButton;

    @FindBy(css = "input#passp-field-passwd")
    WebElement passwordInput;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LogInPage logIn(String username, String password) {
        loginOption.click();
        usernameInput.sendKeys(username);
        loginButton.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        return PageFactory.initElements(driver, LogInPage.class);
    }
}