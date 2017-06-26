package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CheckOutPage extends PageObject {

    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#box-checkout-cart button[name=remove_cart_item]")
    public WebElement removeButton;

    @FindBy(css = "#order_confirmation-wrapper  tr")
    public List<WebElement> productRow;

    public boolean removeItem(){
        int actual = productRow.size();
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until((WebDriver d) -> actual > productRow.size());
        return true;
    }
}
