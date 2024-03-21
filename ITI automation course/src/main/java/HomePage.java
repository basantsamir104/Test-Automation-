//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.levelset.com/";
    By getPaidLocator = By.xpath("//a[@data-instance='Primary navigation: button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHome() {
        this.driver.get(this.url);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(4L));

        try {
            ((WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.getPaidLocator))).click();
        } catch (TimeoutException var2) {
            System.out.println(var2.getMessage());
        }

    }

    public void clickOnGetPaid() {
        this.driver.findElement(this.getPaidLocator).click();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(1L));
        DocumentsPage documents = new DocumentsPage(this.driver);

        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(documents.releaseLocator));
        } catch (TimeoutException var3) {
            System.out.println(var3.getMessage());
        }

    }
}
