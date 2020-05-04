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

public class ArgosPriceRangeList {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void nikePriceList(){
       WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("nike");

        WebElement searchButton = driver.findElement(By.className("_1gqeQ"));
        searchButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600);");

        List<WebElement> priceRanges = driver.findElements(By.cssSelector("#findability > div > div.bolt-v2.search > div > div:nth-child(3) > div > div > div.Drawerstyles__Container-mvyw7g-1.bFJNkA.filter-panel--static.filter-panel.lg-3--none > div > div > div:nth-child(2) > div:nth-child(2) > div > div > div > div"));

        for (WebElement priceRange : priceRanges)
        {   System.out.println(priceRange.getText());

            if(priceRange.getText().contains("£15 - £20"));
            priceRange.click();

        }

    }
}
