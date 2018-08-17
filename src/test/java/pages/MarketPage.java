package pages;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.WebWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.common.AnyPage;

import java.net.URL;
import java.util.List;

public class MarketPage extends AnyPage {


    @FindBy(xpath = "//*[contains(text(),'Маркет')][@data-id = 'market']")
    private List<WebElement> yandexMarketTab;


    public void initialize() {

    }

    public void cleanUp() {
    }

    public WebResponse getWebResponse() {
        return null;
    }

    public WebWindow getEnclosingWindow() {
        return null;
    }

    public URL getUrl() {
        return null;
    }

    public boolean isHtmlPage() {
        return false;
    }

    private void switchToYandexMarketTab() {
        WebElement marketTab = yandexMarketTab.get(1);
        marketTab.click();
    }

    private void sweetchToElectronicks() {
    }

    public String getBalance() {
        WebDriver driver = new ChromeDriver();// Заглушка чтобы пока не сифонило
        driver.findElement(By.xpath("//a[@class='refresh-link']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("//*[@id='acc-content']/div[2]/div[2]")).getText()
                .replaceAll("\\s", "");
    }
}
