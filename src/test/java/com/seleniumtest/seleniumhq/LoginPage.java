package com.seleniumtest.seleniumhq;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements AnyPage {
    //    private String pagelink = "http://www.yandex.ru";
    By usernameLocator = By.xpath(".//INPUT[@class='input__control input__input' and @name = 'login']']");
    By passwordLocator = By.id(".//INPUT[@class='input__control input__input' and @name = 'passwd']");
    By loginButtonLocator = By.id(".//BUTTON[@class='button auth__button domik2__auth-button button_theme_bordergray button_size_m i-bem button_js_inited button_focused_yes button_hovered_yes']");

    private final WebDriver driver;
    private String initialPage;


    public LoginPage(WebDriver driver, String initialPage) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        this.initialPage = initialPage;
        openInitialPage(driver);
        if (!"Яндекс".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openInitialPage(driver);
        if (!"Яндекс".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    private void openInitialPage(WebDriver s) {
        driver.get(initialPage);
    }

    public LoginPage typeUsername(String username) {
//        driver.findElement(usernameLocator).click();
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver);
    }

    public LoginPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}