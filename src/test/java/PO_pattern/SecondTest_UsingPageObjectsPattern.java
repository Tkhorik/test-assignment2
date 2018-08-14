package PO_pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.common.TestBase;

public class SecondTest_UsingPageObjectsPattern extends TestBase {
    private SearchPage searchPage = new SearchPage(driver);
    private AlphaPage alphaPage = new AlphaPage(driver);

    @Before
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void secondTest() throws InterruptedException {
        searchPage.search("Альфа-Банк");
        searchPage.switchToResilt("alfabank.ru");
        clickOnText("Вакансии"); //todo: валится на поиске элемента, поправить
        Thread.sleep(3000);
        clickOnText("О работе в банке");


        Thread.sleep(3000);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}