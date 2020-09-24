package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionDemo {

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
    public void action() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement mouseHover = driver.findElement(By.id("mousehover"));

        Actions action = new Actions(driver);
        action.moveToElement(mouseHover).perform();

        WebElement subelement = driver.findElement(By.linkText("Top"));
        action.moveToElement(subelement).click().perform();
    }

    @After
    public void close() {
        driver.close();
    }
}
<<<<<<< HEAD
//Corrected at 28/08/2020 6.33am
=======
>>>>>>> c25e32e0423f527108c0043b853ffdb4e2d07a0b
