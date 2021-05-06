import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    public void registrationNewUser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ioana");
        driver.findElement(By.id("lastname")).sendKeys("Boros");
        driver.findElement(By.id("email_address")).sendKeys("boros.ioana95@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("confirmation")).sendKeys("12345");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.quit();
    }
}
