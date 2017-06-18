import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ninth_2Task extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/admin/?app=geo_zones&doc=geo_zones";
    private String rowLocator = ".//table//tr[@class='row']";
    private String geoZonesLocator = "//*[@id='table-zones']//td[3]/select";
    private WebElement link;
    @Before
    public void start(){
        driver.get(url);
        AdminLoginPage adminLogin = new AdminLoginPage(driver);
        adminLogin.Login("admin", "admin");
    }
    public boolean checkSort(List<WebElement> items){
        ArrayList<String> itemsNames = new ArrayList();
        for (WebElement i : items) itemsNames.add(i.getText());

        ArrayList<String> sortedItems = new ArrayList();
        sortedItems.addAll(itemsNames);

        //Collections.reverse(sortedCountry);
        Collections.sort(sortedItems);

        return sortedItems.equals(itemsNames);
    }

    @Test
    public  void checkCountrySort9_2(){

        List<WebElement> rows = driver.findElements(By.xpath(rowLocator));
        for (WebElement row : rows ){
            link = row.findElement(By.xpath(".//td[3]/a"));
            link.sendKeys(Keys.CONTROL, Keys.RETURN);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            List<WebElement> geoZones = driver.findElements(By.xpath(geoZonesLocator));
            Assert.assertTrue(checkSort(geoZones));
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }
}

