package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class Practice19062020 {
    public static WebDriver driver;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void argosHomePageFunctionality() throws InterruptedException {
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollBy(0,200)");
//    js.executeScript("window,scrollBy(0,-200)");

        WebElement shopButton = driver.findElement(By.className("_13iYl"));

        Actions action = new Actions(driver);
        action.moveToElement(shopButton).perform();

        Thread.sleep(2000);
        WebElement appliances = driver.findElement(By.linkText("Appliances"));
        action.moveToElement(appliances).build().perform();

    }//@Test method end

    @Test
    public void fathersDay() {
        WebElement cookies = driver.findElement(By.linkText("GOT IT"));
        cookies.click();
        WebElement fatherday = driver.findElement(By.xpath("//span[contains(text(),\"Father's Day\")]"));
        fatherday.click();
        System.out.println("Current Page Get Text is: " + fatherday.getText());

        String actualTitleAssert = driver.getTitle();
        System.out.println("Get Current Page Title is: " + actualTitleAssert);
       // Assert.assertThat(actualTitleAssert, Matchers.containsString("Father's Day Gifts & Ideas | 21 June 2020 | Argos"));

        String actualcurrentURL = driver.getCurrentUrl();
        System.out.println("Get current page title is: " +actualcurrentURL);
        Assert.assertThat(actualcurrentURL, Matchers.containsString("/fathers-day?tag=ar:topnav:button1:fathers-day&clickOrigin=header:home:fathers+day"));



    }

    @After
    public void tearDown() throws InterruptedException {
        //  driver.quit();
    }//@Test method end
}// Class end
