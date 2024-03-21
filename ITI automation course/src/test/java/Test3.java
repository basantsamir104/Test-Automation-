import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
    WebDriver driver;

    public Test3() {
    }

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        this.driver = new ChromeDriver(options);
    }

    @Test
    public void test1() {
        HomePage home = new HomePage(this.driver);
        home.navigateToHome();
        home.clickOnGetPaid();
        DocumentsPage document = new DocumentsPage(this.driver);
        WebElement releaseDocumentPrice = document.getReleaseDocumentPrice();
        Assert.assertEquals(releaseDocumentPrice.getText(), "$149");
    }

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}
