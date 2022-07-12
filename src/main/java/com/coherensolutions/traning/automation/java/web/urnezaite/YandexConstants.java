package com.coherensolutions.traning.automation.java.web.urnezaite;

import org.openqa.selenium.By;

public class YandexConstants {
    public static final String YANDEX_MAIL_LINK = "https://mail.yandex.com/";
    public static final By LOGIN_OPTION = By.partialLinkText("Log in");
    public static final By USERNAME_INPUT = By.cssSelector("input[id='passp-field-login']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@id='passp:sign-in']");
    public static final By PASSWORD_INPUT = By.cssSelector("input#passp-field-passwd");
    public static final By USERNAME_LOCATOR = By.xpath("//span[contains(@class, 'user-account')]");
    public static final By MAIL_ICON = By.xpath("//div[contains(@class, 'PSHeaderIcon-Image_Mail')]");
    public static final By COMPOSE_BUTTON = By.cssSelector("a[href='#compose']");
    public static final By USER_OPTIONS_LOCATOR = By.cssSelector("a.user-account.user-account_left-name");
    public static final By LOGOUT_BUTTON = By.xpath("//span[contains(text(),'Log out')]");
    public static final By CREATE_ACCOUNT_OPTION = By.partialLinkText("Create an account");
}