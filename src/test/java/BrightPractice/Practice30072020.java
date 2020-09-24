package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Practice30072020 {
    public static WebDriver driver;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://zaizi.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void whoWeAre(){
        WebElement whoWe = driver.findElement(By.xpath("//a[contains(text(),'Who We Are')]"));
        whoWe.click();
        WebElement viewAll = driver.findElement(By.xpath("//a[contains(text(),'View All')]"));
        viewAll.click();
        WebElement loadMore = driver.findElement(By.xpath("//a[@class='button']"));
        loadMore.click();
    }

    @After
    public void closebrowser(){
        //driver.close();
    }

}
// please add assertion