package Tests;

import Pages.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    protected static WebDriver driver;
    MainPage mainPage;
    ProductPage productPage;
    CheckOutPage checkOutPage;
    AdminPage adminPage;
    AdminLoginPage adminLoginPage;
    CountryPage countryPage;

    public FunctionalTest(){

        mainPage = new MainPage(driver);
        productPage =  new ProductPage(driver);
        checkOutPage = new CheckOutPage(driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminPage = new AdminPage(driver);
        countryPage = new CountryPage(driver);

     }

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}