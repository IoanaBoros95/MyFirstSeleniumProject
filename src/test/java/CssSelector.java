import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchIcon() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".input-box .search-button")).click();
    }
    @Test
    public void  deleteProductButton() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-5 .level0")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        driver.findElement(By.cssSelector("#swatch27")).click();
        driver.findElement(By.cssSelector("#swatch81")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector(".product-cart-remove .btn-remove")).click();
    }
    @Test
    public void proceedToCheckout() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-5 .level0")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        driver.findElement(By.cssSelector("#swatch27")).click();
        driver.findElement(By.cssSelector("#swatch81")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector(".method-checkout-cart-methods-onepage-bottom .btn-proceed-checkout")).click();
    }

    @Test
    public void sortBy() throws InterruptedException {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-5 .level0")).click();
        driver.findElement(By.cssSelector(".sort-by select")).click();
        Thread.sleep(3000);
    }
    @After
    public void close() {
        driver.quit();
    }
}
