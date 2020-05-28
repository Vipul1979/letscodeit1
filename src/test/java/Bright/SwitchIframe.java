package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchIframe {
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
    public void iframe() throws InterruptedException {
        Thread.sleep(3000);

        driver.switchTo().frame("courses-iframe"); //enter into iframe

        WebElement searchCourse = driver.findElement(By.id("search-courses")); //here it throws error and says NoSuchElementException
        searchCourse.sendKeys("Java");

        driver.switchTo().defaultContent(); //come out from iframe and move back to parent frame
        // or driver.switchTo().parentFrame();
        /*To move back to the parent frame,
        you can either use switchTo().parentFrame()
        or if you want to get back to the main (or most parent) frame,
        you can use driver.switchTo().defaultContent(); */
        WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
        bmwRadio.click();
    }


}
