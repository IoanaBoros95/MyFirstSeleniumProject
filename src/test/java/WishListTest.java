import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void addToWishList() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-5 .level0")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        WebElement requiredText = driver.findElement(By.cssSelector("p.required"));
        Assert.assertEquals("* Required Fields", requiredText.getText());
        driver.findElement(By.cssSelector("#swatch27")).click();
        driver.findElement(By.cssSelector("#swatch81")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons button")).click();
    }

    @Test
    public void sortByPrice() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".nav-6 .level0")).click();
        driver.findElement(By.cssSelector("#narrow-by-list .odd ol li a")).click();
        WebElement sortByText = driver.findElement(By.cssSelector(".currently .block-subtitle"));
        Assert.assertEquals("CURRENTLY SHOPPING BY:", sortByText.getText());
    }

    @Test
    public void goToMyWishList() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='My Wishlist']")).click();
        WebElement pageTitle = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("MY WISHLIST", pageTitle.getText());
    }

    @Test
    public void goToNewsLetterAndBackToDashboard() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='My Wishlist']")).click();
        driver.findElement(By.cssSelector(".current a")).click();
        driver.findElement(By.cssSelector(".buttons-set .back-link")).click();
        WebElement pageTitle = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("MY DASHBOARD", pageTitle.getText());
    }

    @After
    public void close() {
        driver.quit();
    }
}
