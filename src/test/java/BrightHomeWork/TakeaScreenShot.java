package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeaScreenShot {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

    @Test
    public void facebooklogin() throws InterruptedException {
        WebElement facebkLogIn = driver.findElement(By.id("u_0_b"));
        facebkLogIn.click();
        Thread.sleep(2000);
    }

    @After
    public void ScreenShotTake() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationfile = new File("C:\\Users\\Vipul\\Desktop");
        FileUtils.copyFile(sourcefile,destinationfile);

    }//@Test method end

}//Class end
