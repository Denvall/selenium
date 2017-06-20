import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Task11 extends FunctionalTest {

    private String url = "http://localhost/litecart/public_html/en/";

    String firstName = "First";
    String lastName = "Last";
    String address = "Address";
    String zipCode = "17050";
    String city = "Odesa";
    String email = Math.random() + "@test.com";
    String phone = "+16503332211";
    String password = "Test";
    String confirmedPassword = "Test";
    String country = "US";
    String state ="FL";
    @Before
    public void start() {
        driver.get(url);
    }
    @Test
    public void register(){
        MainPage mainPage = new MainPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        mainPage.createNewCustomer();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeAddress(address);
        registrationPage.typeZipCode(zipCode);
        registrationPage.typeCity(city);
        registrationPage.typePhone(phone);
        registrationPage.typePassword(password, confirmedPassword);
        registrationPage.selectCountry(country);
        registrationPage.selectState(state);
        registrationPage.typeEmail(email);
        registrationPage.createAccount();

        Assert.assertEquals("Your customer account has been created.", mainPage.logicSuccess());
        mainPage.logout();
        mainPage.login(email, password);
        mainPage.logout();



    }
}
