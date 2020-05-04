package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.font.TextHitInfo;
import java.util.concurrent.TimeUnit;

public class JavaScriptScroll {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        //initialization of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);

        //Scroll down by 1900 pixels . 0 for horizontal and 1900 for vertical
        js.executeScript("window.scrollBy(0,1900);");
        Thread.sleep(3000);

        //Scroll up by 1900 pixels
        js.executeScript("window.scrollBy(0,-1900);");
        Thread.sleep(3000);

        WebElement mousehover = driver.findElement(By.id("mousehover"));

        //Scroll page to bring element in to view
        js.executeScript("arguments[0].scrollIntoView(true);",mousehover);
        Thread.sleep(3000);

        //as Mouse Hover is not visible, to make it visible we need to scroll little bit up
        js.executeScript("window.scrollBy(0,-200);");

    }



}
