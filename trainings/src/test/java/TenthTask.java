import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TenthTask extends FunctionalTest {
    private String url = "http://localhost/litecart/public_html/en/";
    @Before
    public void start() {
        driver.get(url);
    }
    @Test
    public void TenTask(){
        MainPage mainPage = new MainPage(driver);
        List<String> main = new ArrayList<>();
        main.add(mainPage.productName.getText());
        main.add(mainPage.regularPrice.getText());
        main.add(mainPage.salePrice.getText());

        Assert.assertTrue(mainPage.salePrice.getSize().getHeight() > mainPage.regularPrice.getSize().getHeight());
        Assert.assertTrue(mainPage.salePrice.getSize().getWidth() > mainPage.regularPrice.getSize().getWidth());

        Assert.assertTrue(mainPage.checkColor(mainPage.regularPrice, MainPage.Color.Grey));
        Assert.assertTrue(mainPage.checkTag(mainPage.regularPrice, "s"));

        Assert.assertTrue(mainPage.checkColor(mainPage.salePrice, MainPage.Color.Red));
        Assert.assertTrue(mainPage.checkTag(mainPage.salePrice, "strong"));

        mainPage.product.click();


        ProductPage productPage = new ProductPage(driver);
        List<String> product = new ArrayList<>();
        product.add(productPage.productName.getText());
        product.add(productPage.regularPrice.getText());
        product.add(productPage.salePrice.getText());

        Assert.assertTrue(productPage.salePrice.getSize().getHeight() > productPage.regularPrice.getSize().getHeight());
        Assert.assertTrue(productPage.salePrice.getSize().getWidth() > productPage.regularPrice.getSize().getWidth());

        Assert.assertTrue(mainPage.checkColor(productPage.regularPrice, MainPage.Color.Grey));
        Assert.assertTrue(mainPage.checkTag(productPage.regularPrice, "s"));

        Assert.assertTrue(mainPage.checkColor(productPage.salePrice, MainPage.Color.Red));
        Assert.assertTrue(mainPage.checkTag(productPage.salePrice, "strong"));



    }
}
