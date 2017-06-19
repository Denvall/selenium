import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class MainPage extends PageObject {

    @FindBy(css = "li.product")
    List<WebElement> products;

    @FindBy(css = "#box-campaigns li.product ")
    WebElement product;

    WebElement regularPrice = product.findElement(By.cssSelector("*.regular-price"));
    WebElement salePrice = product.findElement(By.cssSelector("*.campaign-price"));
    WebElement productName = product.findElement(By.cssSelector("div.name"));



    public MainPage(WebDriver driver) {

        super(driver);
    }

    public int productsQuantity(){
        return products.size();
    }

public boolean checkTag(WebElement element, String expectedTag){
    return Objects.equals(element.getTagName(), expectedTag);
}

public boolean checkColor(WebElement element, Color expectedcolor){
    String color = element.getCssValue("color");

    String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
    int r = Integer.parseInt(numbers[0].trim());
    int g = Integer.parseInt(numbers[1].trim());
    int b = Integer.parseInt(numbers[2].trim());
    switch (expectedcolor){
        case Red:
            return g == 0 && b == 0;
        case Grey:
            return r == b && b == g ;
    }
    return false;
}
enum Color{
    Red, Grey
}
}
