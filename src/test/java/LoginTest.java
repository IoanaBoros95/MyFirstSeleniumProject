import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginUser() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeText = driver.findElement(By.cssSelector(".hello strong"));
        Assert.assertEquals("Hello, Ioana B B!", welcomeText.getText());
        Assert.assertTrue(welcomeText.getText().equals("Hello, Ioana B B!"));
        Assert.assertEquals(true,welcomeText.isDisplayed());
    }

    @Test
    public void loginWithInvalidPassword() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ioana@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement errorTextElement = driver.findElement(By.cssSelector(".error-msg span"));
        Assert.assertEquals("Invalid login or password.", errorTextElement.getText());
    }
    @Test
    public void loginWithoutMandatoryFields() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement emailErrorMessage = driver.findElement(By.id("advice-required-entry-email"));
        Assert.assertEquals("This is a required field.", emailErrorMessage.getText());
        WebElement passwordErroMessage = driver.findElement(By.id("advice-required-entry-pass"));
        Assert.assertEquals("This is a required field.", passwordErroMessage.getText());
    }
    @Test
    public void forgotPassward() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector(".form-list .f-left")).click();
        WebElement forgotPassText = driver.findElement(By.cssSelector(".form-instructions"));
        Assert.assertEquals("Please enter your email address below. You will receive a link to reset your password.", forgotPassText.getText());
    }
    @Test
    public void sendEmail() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("[title='Log In']")).click();
        driver.findElement(By.cssSelector(".form-list .f-left")).click();
        driver.findElement(By.cssSelector(".input-box #email_address")).sendKeys("ioana@gmail.com");
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement sendEmailText = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertEquals("If there is an account associated with ioana@gmail.com you will receive an email with a link to reset your password.", sendEmailText.getText());
    }

    @After
    public void close() {
        driver.quit();
    }
}
