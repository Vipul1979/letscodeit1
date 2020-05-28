package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

    @Test
    public void action() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(3000);


        Actions action = new Actions(driver);
        WebElement mouseHoover = driver.findElement(By.id("mousehover"));
        action.moveToElement(mouseHoover).perform();

        Thread.sleep(2000);
        WebElement subTitleElement = driver.findElement(By.linkText("Top"));
        //System.out.println(subTitleElement.isDisplayed());
        //action.moveToElement(subTitleElement).click().perform();

        Thread.sleep(2000);
        WebElement secondElement = driver.findElement(By.linkText("Reload"));
        action.moveToElement(secondElement).click().perform();
    }

}//Class end
