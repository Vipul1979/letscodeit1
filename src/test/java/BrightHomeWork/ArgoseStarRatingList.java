package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArgoseStarRatingList {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void starRating() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("Nike");

        WebElement searchButton = driver.findElement(By.className("_1gqeQ"));
        searchButton.click();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window,scrollBy(0,800);");

        Thread.sleep(2000);
        List<WebElement> starRatings = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-4132xt-5.gywEET"));
        //.RadioListstyles__Circle-sc-4132xt-10.bqWJGP
        for (WebElement starRate : starRatings) {
            //System.out.println(starRate.getText());
            System.out.println(starRate.getAttribute("id"));
            //starRate.click();

        Thread.sleep(2000);
           //if (starRate.getText().contains("4or more"));
            if (starRate.getAttribute("id").contains("4 or more-label")) ;
            starRate.click();

        }

    }
}
