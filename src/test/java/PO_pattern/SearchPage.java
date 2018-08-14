package PO_pattern;

import PO_pattern.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class SearchPage extends HtmlElement {

    @Name("Search request input")
    @FindBy(xpath = "//INPUT[@id='lst-ib']")
    TextInput requestInput;

    @Name("Search button")
    @FindBy(xpath = "//INPUT[@value='Google Search']|//button[@type=\"submit\"]")
    Button searchButton;

    @Name("Result")
    @FindBy(xpath = ".//A[@href='https://alfabank.ru/'][contains(text(),'Альфа-Банк')]")
    Button searchResult;

    public void search(String request) throws InterruptedException {
        requestInput.sendKeys(request);
        requestInput.sendKeys(Keys.ENTER);
    }

    SearchPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void switchToResilt(String s) {
        searchResult.click();
    }
}


