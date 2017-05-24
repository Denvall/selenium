import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
public class FirstTask {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://www.google.com.ua";
    private String expectedTitle = "Google";

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void FirstTest() {
        driver.manage().window().maximize();
        driver.get(url);
        assertEquals(driver.getTitle(),expectedTitle);
    }
    @After
    public void finish(){
        driver.quit();
    }
}
