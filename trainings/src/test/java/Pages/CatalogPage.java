package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage extends PageObject {

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open(){
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    }
    @FindBy(css = "#content tr:nth-child(n+5):nth-child(-n+9) td:nth-child(3) > a")
    public List <WebElement> items;


        }
