package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;


public class CheckOutPage extends PageObject {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private String removeButton = "#box-checkout-cart button[name=remove_cart_item]";

    public void removeItem(){
        driver.findElement(By.cssSelector(removeButton)).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("#order_confirmation-wrapper  tr"))));
    }
}
