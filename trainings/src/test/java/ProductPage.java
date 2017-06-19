import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#box-product")
    WebElement product;

    WebElement regularPrice = product.findElement(By.cssSelector("*.regular-price"));
    WebElement salePrice = product.findElement(By.cssSelector("*.campaign-price"));
    WebElement productName = product.findElement(By.cssSelector("h1.title"));
}
