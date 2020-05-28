package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchToIframe {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end
    @Test
    public void typeInsideIframe() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("courses-iframe");

        WebElement seachboxIframe = driver.findElement(By.id("search-courses"));
        seachboxIframe.sendKeys("Java");

        driver.switchTo().defaultContent();

        WebElement clickonButton = driver.findElement(By.id("bmwradio"));
        clickonButton.click();
    }

}
