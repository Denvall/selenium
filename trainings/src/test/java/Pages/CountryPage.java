package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class CountryPage extends PageObject {

        @FindBy(tagName = "h1")
        private WebElement header;

        @FindBy(css = "table td i.fa-external-link")
        List<WebElement> externalLinks;

        public CountryPage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }

        public boolean isInitialized(){
            return header.isDisplayed();
        }

        public boolean openEachLink(){
            boolean result = false;
            for (WebElement link: externalLinks){
                link.click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                driver.close();
                driver.switchTo().window(tabs.get(0));
                if (tabs.size() == 2 && driver.getWindowHandles().size() ==1 ){
                    result = true;
                }
            }

            return result;
        }
    }

