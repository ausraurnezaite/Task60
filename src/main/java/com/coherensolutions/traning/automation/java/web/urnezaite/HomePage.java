package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    final String YANDEX_MAIL_LINK = "https://mail.yandex.com/";

    @FindBy(partialLinkText = "Log in")
    WebElement loginOption;

    @FindBy(css = "input[id='passp-field-login']")
    WebElement usernameInput;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    WebElement loginButton;

    @FindBy(css = "input#passp-field-passwd")
    WebElement passwordInput;

    public HomePage() {
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(YANDEX_MAIL_LINK);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    public void close() {
        driver.close();
    }

    public LogInPage logIn(String username, String password) {
        loginOption.click();
        usernameInput.sendKeys(username);
        loginButton.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new LogInPage(driver);
    }
}