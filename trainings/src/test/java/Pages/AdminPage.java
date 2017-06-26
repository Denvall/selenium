package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageObject {
    @FindBy(tagName = "h1")
    private WebElement header;

    private String catalog = "#box-apps-menu li:nth-child(2)";
    private String addNewProducts = "#content div > a:nth-child(2)";
    private String items = "table tr.row";

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }


}
