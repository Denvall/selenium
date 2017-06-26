package Tests;
import org.junit.Assert;
import org.junit.Test;

public class Task13 extends FunctionalTest {


    @Test
    public void addRemoveItems(){
        mainPage.open();
        for(int i = 0; i < 3; i++){
            mainPage.firstProductClick();
            productPage.addToCart();
            productPage.goHome();
        }
        productPage.goCheckOut();
        for(int i = 0; i < 3; i++){
            Assert.assertTrue(checkOutPage.removeItem());
        }

    }


}
