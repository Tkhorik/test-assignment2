package PO_pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.common.TestBase;

public class TestCase2 extends TestBase {
    private AbstactPage abstactPage = new AbstactPage(driver);
    private AlphaPage alphaPage = new AlphaPage(driver);
    private SearchPage searchPage = new SearchPage(driver);

    @Before
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void secondTest() throws InterruptedException {
        searchPage.search("Альфа-Банк");
        searchPage.switchToFirstResult("alfabank.ru");
        clickOnText("Вакансии");
        Thread.sleep(3000);
        clickOnText("О работе в банке");


        Thread.sleep(3000);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}