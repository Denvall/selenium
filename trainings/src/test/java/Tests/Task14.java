package Tests;

import Pages.AdminLoginPage;
import org.junit.Assert;
import org.junit.Test;

public class Task14 extends FunctionalTest{

    @Test
    public void openExternalLink(){
        adminLoginPage.open();
        adminLoginPage.Login("admin","admin");
        adminPage.country.click();
        adminPage.openCountry(2);
        Assert.assertTrue(countryPage.openEachLink());



    }
}
