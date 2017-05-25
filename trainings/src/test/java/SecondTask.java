import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTask {
    private WebDriver driver;
    private WebDriverWait wait;
    private String loginLocator = "username";
    private String passwordLocator = "password";
    private String submitLocator = "login";
    public String url = "http://localhost/litecart/public_html/admin";
    public String login = "admin";
    public String password = "admin";
    public String expectedTitle = "My Store";

    public void loginEnter (String login){
        driver.findElement(By.name(loginLocator)).sendKeys(login);
    }
    public void passwordEnter(String pass){
        driver.findElement(By.name(passwordLocator)).sendKeys(pass);
}
    public void submitLogin(){
        driver.findElement(By.name(submitLocator)).click();
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void Login(){
        driver.manage().window().maximize();
        driver.get(url);
        loginEnter(login);
        passwordEnter(password);
        submitLogin();
        assertEquals(expectedTitle, driver.getTitle());
    }
    @After
    public void finish(){
        driver.quit();
    }
 }
