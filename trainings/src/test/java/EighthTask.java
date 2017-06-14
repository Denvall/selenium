import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EighthTask extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/en/";
    private String stickerLocator = "div.sticker";

    @Before
    public void start(){
        driver.get(url);
    }


    @Test
    public void compare(){
        MainPage main = new MainPage(driver);

       for(WebElement product : main.products){
            Assert.assertTrue(product.findElements(By.cssSelector(stickerLocator)).size() == 1);
        }
    }
}
