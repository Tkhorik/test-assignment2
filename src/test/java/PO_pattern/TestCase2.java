package PO_pattern;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.common.TestBase;

import java.io.*;
import java.util.Date;

public class TestCase2 extends TestBase {
    private AbstactPage abstactPage = new AbstactPage(driver);
    private AlphaPage alphaPage = new AlphaPage(driver);
    private SearchPage searchPage = new SearchPage(driver);

    public String getSearchEngineName() {
        return searchEngineName;
    }

    public void setSearchEngineName(String searchEngineName) {
        this.searchEngineName = searchEngineName;
    }

    private String searchEngineName;

    @Before
    public void loadPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void secondTest() throws InterruptedException {

        saveSearchEngineName();
        prepareEngineNameString();
        searchPage.search("Альфа-Банк");
        searchPage.switchToFirstResult("alfabank.ru");
        clickOnText("Вакансии");
        Thread.sleep(3000);
        clickOnText("О работе в банке");
        Thread.sleep(3000);
        try {
            saveVacancyTextBlockIntoFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String saveSearchEngineName() {
        return driver.getCurrentUrl();
    }

    private String prepareEngineNameString() {
        String stringFromCommanline = saveSearchEngineName();
        String afterBeginingStringRemoving = (stringFromCommanline.substring(stringFromCommanline.indexOf(".") + 1));
        return (afterBeginingStringRemoving.substring(0, afterBeginingStringRemoving.indexOf(".")));
    }

    private void saveVacancyTextBlockIntoFile() throws IOException {
/*
        Имя должно содержать дату и время прогона.
                Имя должно содержать название браузера, в котором совершался прогон.
                Имя должно содержать название поисковой системы*/
        System.out.println(new Date().toString());
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String os = cap.getPlatform().toString();
        System.out.println(os);
        String v = cap.getVersion();
        System.out.println(v);

        String fileName1 = new StringBuilder((new Date().toString()))
                .append("_")
                .append(browserName)
                .append("_")
                .append(prepareEngineNameString()).append(".txt").toString();
        String fileName = fileName1.replaceAll("\\s+", "_").replaceAll(":", "-").trim();
        System.out.println(fileName);


        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
            writer.write(alphaPage.vacancyTextBlock.getText());
            System.out.println("запись в файл была произведена");
        } catch (IOException ex) {
            // Report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/*ignore*/}
        }
    }


    @After
    public void closeDriver() {
        driver.quit();
    }
}