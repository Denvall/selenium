package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage extends PageObject {
    @FindBy(tagName = "h1")
    private WebElement header;

    private String catalog = "#box-apps-menu li:nth-child(2)";
    private String addNewProducts = "#content div > a:nth-child(2)";
    private String items = "table tr.row";

    @FindBy(css = "#box-apps-menu li:nth-child(3)")
    public WebElement country;

    @FindBy(css = "table.dataTable td:nth-child(5) > a")
    public List<WebElement> countries;


    public AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }

    public void openCountry(int index){
        countries.get(index).click();
    }


}
