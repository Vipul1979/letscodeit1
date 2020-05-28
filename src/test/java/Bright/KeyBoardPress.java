package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyBoardPress {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }//Before method end

    @Test
    public void keyPress(){
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        WebElement userName = driver.findElement(By.id("user_email"));
        userName.sendKeys("test@gmail.com");
        userName.sendKeys(Keys.TAB);

        WebElement passWord = driver.findElement(By.id("user_password"));
        passWord.sendKeys("12345678");
        passWord.sendKeys(Keys.ENTER);

    }
        @Test
        public void combineKeyPress(){
        WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
        bmwRadio.click();

        bmwRadio.sendKeys(Keys.CONTROL + "a",Keys.CONTROL + "c");

        WebElement searchbox = driver.findElement(By.id("name"));
        searchbox.click();
        searchbox.sendKeys(Keys.CONTROL + "v");
        }
        @After
    public void close(){
      //  driver.quit();
        }
}
