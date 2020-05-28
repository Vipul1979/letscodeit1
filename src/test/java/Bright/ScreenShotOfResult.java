package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShotOfResult {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }//Before method end

    @Test
    public void result() throws InterruptedException {
        WebElement loginButton= driver.findElement(By.id("u_0_b"));
        loginButton.click();
        Thread.sleep(3000); //very important. without it may take homepage screenshot.

    }//@Test method end

    //You must need to get "commons 2.6" depenency from central repocitory
    @After
    public void teardown() throws IOException {
        //Convert driver object to TakeScreenshot
        //TakesScreenshot is from org.openqa.selenium not from Brighwork
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File destinationfile = new File("C:\\Users\\Vipul\\Desktop\\ScreenShotFile.png"); //File (java.io)
        //Copy file at destination
        FileUtils.copyFile(sourcefile,destinationfile);  // copyFile it will throws exception, IOException click on red bulb and add IOException
        //FileUtils is from org.apache.commons.io
        //copyFile is from (File srcFile,File destFile)
    }
}
