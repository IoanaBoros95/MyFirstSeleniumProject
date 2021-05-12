import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void registrationNewUser() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ioana");
        driver.findElement(By.id("lastname")).sendKeys("Boros");
        driver.findElement(By.id("email_address")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        WebElement infoText = driver.findElement(By.cssSelector(".form-instructions"));
        Assert.assertEquals("Please enter the following information to create your account.", infoText.getText());
        driver.quit();
    }

    @Test
    public void registrationUserFieldRequiredText() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ioana");
        driver.findElement(By.id("lastname")).sendKeys("Boros");
        driver.findElement(By.id("email_address")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        //driver.findElement(By.id("confirmation")).sendKeys("12345");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set button")).click();
        WebElement requiredText = driver.findElement(By.id("advice-required-entry-confirmation"));
        Assert.assertEquals("This is a required field.", requiredText.getText());
    }

    @After
    public void close() {
        driver.quit();
    }
}
