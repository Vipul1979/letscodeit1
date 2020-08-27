package BrightPractice;

import gherkin.lexer.Fi;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Practice16082020 {
    public static WebDriver driver;

    @Before
    public void ActionDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get("https://letskodeit.teachable.com/p/practice");
        // driver.get("https://letskodeit.teachable.com/");
        //driver.get("https://www.argos.co.uk/");
        driver.get("https://www.eagleeye.com/company/our-board");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebElement practice = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/ul/li[1]/a"));
        practice.click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Actions action = new Actions(driver);
        WebElement mouseHoover = driver.findElement(By.id("mousehover"));

        action.moveToElement(mouseHoover).perform();
        Thread.sleep(2000);
        WebElement reload = driver.findElement(By.linkText("Reload"));
        action.moveToElement(reload).click().perform();

    }

    @Test
    public void navigateMethod() {

        driver.navigate().to("https://letskodeit.teachable.com/p/practice");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @After
    public void tearDown() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\Vipul\\Desktop\\ScreenShot.png");
        FileUtils.copyFile(sourceFile, destinationFile);

        // driver.quit();

    }

    @Test
    public void clickTimProfileandAssertresultpage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-800)");

        Thread.sleep(2000);
        WebElement timMason = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div/div/div[1]/div/a/span"));
        //timMason.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(timMason).build().perform();

        String actualtimMasonURL = driver.getCurrentUrl();
        System.out.println(actualtimMasonURL);

        Assert.assertThat(actualtimMasonURL, Matchers.equalTo("https://www.eagleeye.com/company/our-exec/tim-mason"));

    }
}
