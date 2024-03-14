import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
    String url = "https://www.google.com/";
    String searchWord = "Test Automation";
    WebDriver driver;
    By searchBar = By.name("q");
    By searchStats = By.id("result-stats");

    @Test
    public void test1(){
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.findElement(searchBar).sendKeys(searchWord);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
        WebElement stats = driver.findElement(searchStats);
        Assert.assertTrue(stats.getText().contains("724,000,000"));

    }
}