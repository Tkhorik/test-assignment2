package com.seleniumtest.seleniumhq;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.support.PageFactory;

public class UsingGoogleSearchPage {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://www.google.com/");

        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        page.searchFor("Cheese");
    }
}