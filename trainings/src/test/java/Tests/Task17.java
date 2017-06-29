package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by denvall on 29.06.2017.
 */
public class Task17 extends FunctionalTest {

    @After
    public void finish() {
        Assert.assertTrue(driver.manage().logs().get("browser").filter(Level.ALL).isEmpty());
    }

    @Test
    public void openPages() {
        catalogPage.open();
        adminLoginPage.Login("admin", "admin");
        for ( WebElement item : catalogPage.items) {
            item.sendKeys(Keys.CONTROL, Keys.RETURN);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

    }
}