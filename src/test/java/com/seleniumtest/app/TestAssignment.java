package com.seleniumtest.app;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAssignment {
    @Test
    public void firstTest() throws InterruptedException {
        final String s = System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.yandex.ru");
        switchToMarketTabFromYandexPage();
/*        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();*/
        Thread.sleep(5000);
        driver.quit();
    }

    private void switchToMarketTabFromYandexPage() throws InterruptedException {
//        WebElement markretTab = By.xpath("html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]").findElement(driver);
//        markretTab.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeDriver(){

    }
}
