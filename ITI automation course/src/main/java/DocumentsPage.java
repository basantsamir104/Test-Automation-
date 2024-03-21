//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentsPage {
    WebDriver driver;
    public By releaseLocator = By.xpath("(//div[@class='left'])[4]");
    public By releasePriceLocator = By.xpath("(//div[@class='left'])[4]/following-sibling::div/span");

    public DocumentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getReleaseDocument() {
        return this.driver.findElement(this.releaseLocator);
    }

    public WebElement getReleaseDocumentPrice() {
        return this.driver.findElement(this.releasePriceLocator);
    }
}
