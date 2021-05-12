import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void goToCheckoutBeforeAddingToCart() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Checkout']")).click();
        WebElement pageTitle = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("SHOPPING CART IS EMPTY", pageTitle.getText());
    }

    @Test
    public void redirectToMainPage() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Checkout']")).click();
        driver.findElement(By.cssSelector(".cart-empty a")).click();
        WebElement welcomeText = driver.findElement(By.cssSelector(".welcome-msg"));
        Assert.assertEquals("WELCOME", welcomeText.getText());
    }

    @Test
    public void goToCheckoutAfterAddingToCart() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-5 .level0")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        driver.findElement(By.cssSelector("#swatch27")).click();
        driver.findElement(By.cssSelector("#swatch81")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons button")).click();
        driver.findElement(By.cssSelector(".checkout-types .btn-proceed-checkout")).click();
        WebElement checkoutText = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("CHECKOUT", checkoutText.getText());
    }

    @After
    public void close() {
        driver.quit();
    }
}
