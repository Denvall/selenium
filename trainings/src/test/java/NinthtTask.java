import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by denvall on 14.06.17.
 */
public class NinthtTask extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/admin/?app=countries&doc=countries";


    @Before
    public void start(){
        driver.get(url);
        AdminLoginPage adminLogin = new AdminLoginPage(driver);
        adminLogin.Login("admin", "admin");
    }

    @Test
    public void checkCountrySort(){

        List<WebElement> countries = driver.findElements(By.xpath(".//table//tr[@class='row']//td[5]"));
        ArrayList<String> countryNames = new ArrayList();
        for(WebElement country : countries){
            countryNames.add(country.getText());
        }
        ArrayList<String> sortedCountry = new ArrayList();
        for (String c : countryNames){
            sortedCountry.add(c);
        }
        Collections.sort(sortedCountry);
        //Collections.reverse(sortedCountry);
        Assert.assertTrue(sortedCountry.equals(countryNames));
    }

}