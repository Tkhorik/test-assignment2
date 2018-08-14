package PO_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class AlphaPage {

    @Name("Vacancy")
    @FindBy(xpath = "//*[contains(text(),'Вакансии')]")
    Button vacancyBytton;

    AlphaPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }
}
