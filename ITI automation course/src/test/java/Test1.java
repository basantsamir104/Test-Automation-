import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
    String url = "https://www.google.com/";
    String searchWord = "Test Automation";
    WebDriver driver;
    By searchBar = By.name("q");
    By searchStats = By.id("result-stats");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @Test
    public void test1(){
        driver.findElement(searchBar).sendKeys(searchWord);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
        WebElement stats = driver.findElement(searchStats);
        Assert.assertTrue(stats.getText().contains("724,000,000"));
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}