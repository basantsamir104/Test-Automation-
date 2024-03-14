import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    private WebDriver driver;
    private String url = "https://www.saucedemo.com/";
    private String cartUrl = "https://www.saucedemo.com/cart.html";
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    public void login(String username , String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }
    public WebElement addItemToCart(String itemName) {
        String locator = "//div[@class='inventory_item_name ' and text()='%s']/ancestor::div/following-sibling::div/button"; //text() instead of contains() 3ashan maye3melsh return le more than 1 item
        String s = String.format(locator, itemName);
        return driver.findElement(By.xpath(s));
    }

    public boolean checkIfItemIsInCart(String itemName) {
        driver.get(cartUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        String locator = "//div[@class='inventory_item_name' and text()='%s']";
        String s = String.format(locator,itemName);
        By itemLocator = By.xpath(s);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @BeforeTest
    public void setupAndLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get(url);
        login("standard_user","secret_sauce");
    }

    @Test
    public void test1() {
        String searchItem = "Sauce Labs Backpack";
        addItemToCart(searchItem).click();
        Assert.assertTrue(checkIfItemIsInCart(searchItem) , "Item not found");

        /*WebElement loginPageHeader = driver.findElement(By.className("login_logo"));
        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs1","login page header is not Swag Labs1");*/
        // driver.quit();

    }

    @Test
    public void test2() {
        List<WebElement> Items = driver.findElements(By.className("inventory_item")); //did not work with "inventory_item_name " , why?
        Assert.assertEquals(Items.size(), 6, "The number of inventory items is not 6");


    }
}