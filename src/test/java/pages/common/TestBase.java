package pages.common;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.openqa.selenium.By.xpath;

public class TestBase {

    protected static WebDriver driver;


    @BeforeClass
    public static void setUp() {
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        final String s = System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    protected void goToYandexPage() {
        final String s = System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.yandex.ru");

    }

    protected void clickOnText(String s) {
        driver.findElement(xpath(".//*[contains(text(),'" + s + "')]"));
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            System.out.println("Closing chrome browser");
//            driver.quit();
        }
    }
}
