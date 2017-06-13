import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EighthTask extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/en/";

    @Before
    public void start(){
        driver.get(url);
    }


    @Test
    public void compare(){
        MainPage main = new MainPage(driver);
        Assert.assertArrayEquals(new int[]{main.stickersQuantity()}, new int[]{main.productsQuantity()});
    }
}
