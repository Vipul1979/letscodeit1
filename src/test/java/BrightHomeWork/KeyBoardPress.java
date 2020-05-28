package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    }//@Before method end

    @Test
    public void keyboadPress() throws InterruptedException {
        WebElement bmwButton = driver.findElement(By.id("bmwradio"));
        bmwButton.click();
        bmwButton.sendKeys(Keys.CONTROL + "a", Keys.CONTROL + "c");

        WebElement enterName = driver.findElement(By.id("name"));
        Thread.sleep(3000);
        enterName.click();
        enterName.sendKeys(Keys.CONTROL + "v");


    }
}
