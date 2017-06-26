package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CountryPage extends PageObject {

        @FindBy(tagName = "h1")
        private WebElement header;

        public CountryPage(WebDriver driver) {
            super(driver);
        }

        public boolean isInitialized(){
            return header.isDisplayed();
        }
    }

