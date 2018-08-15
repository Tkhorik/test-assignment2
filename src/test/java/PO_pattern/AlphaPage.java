package PO_pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.openqa.selenium.By.xpath;

public class AlphaPage extends AbstactPage {

    @Name("Vacancy")
    @FindBy(xpath = "//*[contains(text(),'Вакансии')]")
    Button vacancyBytton;



    public AlphaPage(WebDriver driver) {
        super(driver);
    }
}
