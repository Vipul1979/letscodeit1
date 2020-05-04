package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ArgosPriceRange {

   //public static WebDriver driver; //if we don't write here then can not access in @Test anotation
public static WebDriver driver;
    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32 (1)\\chromedriver_win32 version 81\\chromedriver.exe");
       WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    } //set up method end

    @Test
    public void setSearchbox() {
        WebElement searchbox = driver.findElement(By.id("searchTerm"));
        searchbox.sendKeys("nike");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement searchClick = driver.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[3]/div/form/button/span[2]"));
        searchClick.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement clickPricerageFivetoTen = driver.findElement(By.cssSelector("#filter-price-£5\\ -\\ £10-label > div > div > span > span"));
        clickPricerageFivetoTen.click();

    }
}
