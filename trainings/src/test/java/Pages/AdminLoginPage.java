package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class AdminLoginPage extends PageObject {

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement submitButton;

    public AdminLoginPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void open() {
        driver.get("http://localhost/litecart/public_html/admin/");
    }

    public void EnterLogin(String login){
        this.loginField.clear();
        this.loginField.sendKeys(login);
    }

    public void EnterPassword(String password){
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void Submit(){
        this.submitButton.click();
    }
    public void Login(String login, String password ){
        EnterLogin(login);
        EnterPassword(password);
        Submit();
    }





}
