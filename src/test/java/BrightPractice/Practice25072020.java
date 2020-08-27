package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice25072020 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement books = driver.findElement(By.linkText("Books"));
        books.click();

        WebElement grid = driver.findElement(By.linkText("Grid"));
        grid.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-1000);");

        //Thread.sleep(1000);
        WebElement productSortOrder = driver.findElement(By.id("products-orderby"));
        Select select = new Select(productSortOrder);
        //select.selectByIndex(1);
       // Thread.sleep(1000);
        //select.selectByIndex(4);

        select.selectByVisibleText("Name: A to Z");

        List<WebElement> products = driver.findElements(By.cssSelector(".item-box"));
        for (WebElement product : products
             ) {System.out.println(product.getText());

             if (product.getText().contains("First Prize")){
                 product.click();
             }

        }


    }
}
