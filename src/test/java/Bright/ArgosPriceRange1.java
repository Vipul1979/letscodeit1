package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ArgosPriceRange1 {

    public static WebDriver driver1;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.get("https://www.argos.co.uk/");
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Before method executed");
    } //@Before end

    @Test
    public void test1() {
        WebElement searchBox = driver1.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        driver1.findElement(By.linkText("GOT IT")).click();

        searchBox.sendKeys("Trimmer");
        WebElement searchButton = driver1.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[3]/div/form/button/span[2]"));
        searchButton.click();
        System.out.println("Test 1 method executed");

        WebElement priceRange10to15 = driver1.findElement(By.cssSelector("#filter-price-£10\\ -\\ £15-label > div > div > svg"));
        priceRange10to15.click();
    }//test1 method end
    @Test
    public void test2(){
        WebElement searchBox = driver1.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        searchBox.sendKeys("adidas");

        driver1.findElement(By.linkText("GOT IT")).click();

        WebElement searchButton = driver1.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[3]/div/form/button/span[2]"));
        searchButton.click();
        System.out.println("Test 2 method executed");
    }

    @After
    public void closeBrowser() {
        driver1.quit();
        System.out.println("After method executed");
    }//@After method end
}

