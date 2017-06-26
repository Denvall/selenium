package Pages;

import Pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.*;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#box-product")
    public WebElement product;

    @FindBy(css = "*.regular-price")
    public WebElement regularPrice;

    @FindBy(css = "*.campaign-price")
    public WebElement salePrice;

    @FindBy(css = "h1.title")
    public WebElement productName;

    @FindBy(css = "button[name=add_cart_product]")
    public WebElement addToCartButton;

    @FindBy(css = "#cart span.quantity")
    public WebElement counter;

    @FindBy(css = "#breadcrumbs li:nth-child(1)")
    public WebElement mainPageLink;

    @FindBy(css = "#cart > a.link")
    public WebElement cartLink;

    @FindBy(css = "#box-product td.options > select")
    public List<WebElement> Size;



    public void addToCart() {
        int before = parseInt(counter.getText());
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (Size.size() > 0 ){
            Select selectSize = new Select(Size.get(0));
            selectSize.selectByIndex(1);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until((WebDriver d) -> before < parseInt(counter.getText()));
    }
    public void goHome(){
        mainPageLink.click();
    }

    public void goCheckOut(){
        cartLink.click();
    }
}
