package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/public_html/en/");
    }

    @FindBy(css = "li.product")
    public List<WebElement> products;

    @FindBy(css = "#box-account-login td>a")
    public WebElement newCustomerLink;

    @FindBy(css = "input[name=email]")
    public WebElement emailField;

    @FindBy(css = "input[name=password]")
    public WebElement passwordField;

    @FindBy(css = "button[value=Login]")
    public WebElement loginButton;

    @FindBy(css = "#notices > div.success")
    public WebElement successHeader;

    @FindBy(css = "#box-account ul > li:nth-child(4) > a")
    public WebElement logout;



    public void login(String login, String password){
       emailField.sendKeys(login);
       passwordField.sendKeys(password);
       loginButton.click();
    }

    public String logicSuccess(){
        return successHeader.getText();
    }
    public void createNewCustomer(){
        newCustomerLink.click();
     }
    public void logout(){
         logout.click();
     }
    public void firstProductClick(){
        products.get(0).click();
    }


    public int productsSize(){
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
public enum Color{
    Red, Grey
}
}
