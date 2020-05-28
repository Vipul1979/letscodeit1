package BrightHomeWork;

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
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

    @Test
    public void letskodeit() throws InterruptedException {
        WebElement practicePage = driver.findElement(By.linkText("Practice"));
        practicePage.click();
        Thread.sleep(3000);

    }//@Test method end
    @After
    public void takeScreenShot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationfile = new File("C:\\Users\\Vipul\\Desktop\\letskodeit.png");
        FileUtils.copyFile(sourcefile,destinationfile);
    }//@After method end


}//Class end
