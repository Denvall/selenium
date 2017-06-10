import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageObject{
    @FindBy(tagName = "h1")
    private WebElement header;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }
}
