package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public final By LOGIN_OPTION = By.partialLinkText("Log in");
    public final By USERNAME_INPUT = By.cssSelector("input[id='passp-field-login']");
    public final By LOGIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    public final By PASSWORD_INPUT = By.cssSelector("input#passp-field-passwd");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage logIn(String username, String password) {
        driver.findElement(LOGIN_OPTION).click();
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new LogInPage(driver);
    }
}