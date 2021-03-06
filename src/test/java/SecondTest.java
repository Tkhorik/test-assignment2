import PO_pattern.AlphaPage;
import PO_pattern.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.common.TestBase;

import java.io.*;
import java.util.Date;

public class SecondTest extends TestBase {
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
    public void loadPage() {
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
        saveVacancyTextBlockIntoFile();
    }

    private String saveSearchEngineName() {
        return driver.getCurrentUrl();
    }

    private String prepareEngineNameString() {
        String stringFromCommandline = saveSearchEngineName();
        String afterBeginningStringRemoving = (stringFromCommandline.substring(stringFromCommandline.indexOf(".") + 1));
        return (afterBeginningStringRemoving.substring(0, afterBeginningStringRemoving.indexOf(".")));
    }

    private void saveVacancyTextBlockIntoFile() {
        String browserName = prepareFilenameString();
        String fileName = processTheString(browserName);
        saveTextIntoFile(fileName);
    }

    private String processTheString(String browserName) {
        String fileName1 = new StringBuilder((new Date().toString()))
                .append("_")
                .append(browserName)
                .append("_")
                .append(prepareEngineNameString()).append(".txt").toString();
        return fileName1.replaceAll("\\s+", "_").replaceAll(":", "-").trim();
    }

    private void saveTextIntoFile(String fileName) {
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName), "utf-8"));
            writer.write(alphaPage.vacancyTextBlock.getText());
            System.out.println("\nзапись была произведена в файл " + fileName);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception ex) {/*ignore*/}
        }
    }

    private String prepareFilenameString() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion();
        return browserName;
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}