package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Interview08052020 {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void argosePriceSort() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("Nike");

        WebElement searchButton = driver.findElement(By.xpath("//span[@class='_1gqeQ']"));
        searchButton.click();

        WebElement sortByRelevance = driver.findElement(By.id("sort-select"));
        Select sel = new Select(sortByRelevance);

        sel.selectByIndex(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");

        Thread.sleep(30);
        List<WebElement> prices = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-l8f8q8-14.gHrEdF"));

        for (WebElement price : prices) {
            System.out.println(price.getText());
            Thread.sleep(5000);
            if (price.getText().equals("£69.99")) {

                price.click();
            }
        }
    }
}

