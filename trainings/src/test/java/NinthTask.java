import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NinthTask extends FunctionalTest {
    private WebDriver wait;
    private String url = "http://localhost/litecart/public_html/admin/?app=countries&doc=countries";
    private String countriesLocator = ".//table//tr[@class='row']//td[5]";
    private String rowLocator = ".//table//tr[@class='row']";
    private String timezonesLocator = "*[@id='table-zones']//td[3]";
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

        ArrayList<String> sorteditems = new ArrayList();
        for (String c : itemsNames) sorteditems.add(c);

        //Collections.reverse(sortedCountry);
        Collections.sort(sorteditems);

        return sorteditems.equals(itemsNames);
    }

    @Test
    public void checkCountrySort9_1(){

        List<WebElement> countries = driver.findElements(By.xpath(countriesLocator));
        Assert.assertTrue(checkSort(countries));

        List<WebElement> rows = driver.findElements(By.xpath(rowLocator));


        for(WebElement row : rows){
            String zone = row.findElement(By.xpath(".//td[6]")).getText();
            if(Integer.parseInt(zone) > 0){
                link = row.findElement(By.xpath(".//td[5]/a"));
                link.sendKeys(Keys.CONTROL, Keys.RETURN);
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                List<WebElement> timezones = driver.findElements(By.xpath(timezonesLocator));
                Assert.assertTrue(checkSort(timezones));
                driver.close();
                driver.switchTo().window(tabs.get(0));

            }
            }
        }
    }

