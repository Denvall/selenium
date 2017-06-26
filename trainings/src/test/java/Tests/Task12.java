package Tests;

import Pages.AdminLoginPage;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by denvall on 20.06.17.
 */
public class Task12 extends FunctionalTest{

    private String url = "http://localhost/litecart/public_html/admin/";

    @Before
    public void start(){
        driver.get(url);
        AdminLoginPage loginPage = new AdminLoginPage(driver);
        loginPage.Login("admin", "admin");
    }

    @Test
    public void createProduct(){

    }
}
