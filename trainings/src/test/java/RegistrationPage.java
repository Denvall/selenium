import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageObject{
    
    private String createAccountForm = "#create-account ";

    private String firstName = createAccountForm +  "input[name=firstname]";
    private String lastName = createAccountForm + "input[name=lastname]";
    private String address = createAccountForm + "input[name=address1]";
    private String zipCode = createAccountForm + "input[name=postcode]";
    private String city = createAccountForm + "input[name=city]";
    private String email = createAccountForm + "input[name=email]";
    private String phone = createAccountForm + "input[name=phone]";
    private String password = createAccountForm + "input[name=password]";
    private String confirmedPassword = createAccountForm + "input[name=confirmed_password]";
    private String country = createAccountForm + "select[name=country_code]";
    private String state = createAccountForm + "select[name=zone_code]";
    private String createAccountButton = createAccountForm + "button[name=create_account]";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void createAccount() {
        driver.findElement(By.cssSelector(createAccountButton))
                .click();
    }
    public void typeFirstName(String FirstName) {
        driver.findElement(By.cssSelector(firstName))
                .sendKeys(FirstName);
    }
    public void typeLastName(String LastName) {
        driver.findElement(By.cssSelector(lastName))
                .sendKeys(LastName);
    }

    public void typeAddress(String Address) {
        driver.findElement(By.cssSelector(address))
                .sendKeys(Address);
    }
    public void typeZipCode(String ZipCode) {
        driver.findElement(By.cssSelector(zipCode))
                .sendKeys(ZipCode);
    }
    public void typeCity(String City) {
        driver.findElement(By.cssSelector(city))
                .sendKeys(City);
    }

    public void typeEmail(String Email) {
        driver.findElement(By.cssSelector(email))
                .sendKeys(Email);
    }
    public void typePhone(String Phone) {
        driver.findElement(By.cssSelector(phone))
                .sendKeys(Phone);
    }
    public void typePassword(String Password, String ConfirmedPassword) {
        driver.findElement(By.cssSelector(password))
                .sendKeys(Password);
        driver.findElement(By.cssSelector(confirmedPassword))
                .sendKeys(ConfirmedPassword);
    }

    public void selectCountry(String Country) {
        Select countryDropdown = new Select(driver.findElement(By.cssSelector(country)));
        countryDropdown.selectByValue(Country);
    }
    public void selectState(String State) {
        Select countryDropdown = new Select(driver.findElement(By.cssSelector(state)));
        countryDropdown.selectByValue(State);
    }

}
