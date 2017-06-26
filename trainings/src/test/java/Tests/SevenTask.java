package Tests;

import Pages.AdminLoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SevenTask extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/admin/";
    private String menuLocator = ".//div[@id='box-apps-menu-wrapper']";
    private String menuItemsLocator = ".//li[@id='app-']";
    private String itemLocator = ".//li[@id='app-']";
    private String h1 = ".//h1";
    private String subItemsLocator = "//ul[@class='docs']";
    private String subItemLocator = ".//ul[@class='docs']/li";
    private boolean isElementExist(WebDriver driver, By locator){
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    @Before
    public void Login(){
        driver.get(url);
        AdminLoginPage adminLogin = new AdminLoginPage(driver);
        adminLogin.Login("admin", "admin");
    }
    @Test
    public void Iterate() {
        WebElement menu = driver.findElement(By.xpath(menuLocator));
        List<WebElement> menuItems = menu.findElements(By.xpath(menuItemsLocator));

        for(int i = 1; i <= menuItems.size(); i++){
            WebElement item = driver.findElement(By.xpath(itemLocator + "[" + i + "]"));
            item.click();
            Assert.assertTrue(isElementExist(driver,By.xpath(h1)));
            if (isElementExist(driver, By.xpath(subItemsLocator))){
            List<WebElement> subItems = driver.findElements(By.xpath(subItemLocator));
            for (int j = 1; j <= subItems.size(); j++) {
                WebElement subItem = driver.findElement(By.xpath(subItemLocator + "[" + j + "]"));
                subItem.click();
                Assert.assertTrue(isElementExist(driver, By.xpath(h1)));
            }
            }
        }

    }

}
