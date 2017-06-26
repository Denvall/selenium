package Tests;

import Pages.*;
import org.junit.Test;

public class Task13 extends FunctionalTest {


    @Test
    public void addRemoveItems(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.firstProductClick();
        ProductPage productPage = new ProductPage(driver);

        productPage.addToCart();


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            for (int i = 1; i < 3; i++){
            mainPage.firstProductClick();
            productPage.addToCart();
            productPage.goHome();
        }

    }


}
