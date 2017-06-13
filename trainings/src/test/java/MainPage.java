import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObject {

    @FindBy(css = "div.sticker")
    List<WebElement> stickers;

    @FindBy(css = "li.product")
    List<WebElement> products;

    public MainPage(WebDriver driver) {

        super(driver);
    }
    public int stickersQuantity(){
        return stickers.size();
    }
    public int productsQuantity(){
        return products.size();
    }
}


