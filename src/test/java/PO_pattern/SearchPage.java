package PO_pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchPage extends AbstactPage {

    @Name("Search request input")
    @FindBy(xpath = "//INPUT[@id='lst-ib']")
    TextInput requestInput;

    @Name("Search button")
    @FindBy(xpath = "//INPUT[@value='Google Search']|//button[@type=\"submit\"]")
    Button searchButton;

    @Name("Result")
    @FindBy(xpath = ".//A[@href='https://alfabank.ru/'][contains(text(),'Альфа-Банк')]")
    Button searchResult;

/*    @Name("Search request input")
    @FindBy(xpath = ".//*[@title=\"Search\"]")
    private TextInput requestInput;*/

    public SearchPage() {
        super();
    }

/*    @Name("Search button")
    @FindBy(className = "b-form-button__input")
    private Button searchButton;*/

/*
    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }*/

    public void search(String request) throws InterruptedException {
        requestInput.sendKeys(request);
        requestInput.sendKeys(Keys.ENTER);
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFirstResult(String s) {
        searchResult.click();
    }
}