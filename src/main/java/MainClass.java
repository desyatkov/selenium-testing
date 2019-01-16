import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class MainClass {
  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"/drivers/geckodriver");

    WebDriver driver = new FirefoxDriver();
    driver.get("http://google.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector("[role='combobox']")).sendKeys("twitter");
    driver.findElement(By.cssSelector("[role='combobox']")).sendKeys(Keys.RETURN);
    driver.findElement(By.cssSelector("a[href='https://twitter.com/?lang=he']")).click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href*='signup']")));

    String expectedTitle = "Sign up for Twitter / Twitter";

    assertEquals(expectedTitle, driver.getTitle());

    driver.quit();
  }
}
