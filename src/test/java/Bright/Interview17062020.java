package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Interview17062020 {
public static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.className("_1Rz0y"));
        searchBox.sendKeys("nike");

        List<WebElement> itemList = driver.findElements(By.cssSelector("._3a8zN"));

        for (WebElement item:itemList
             ) {System.out.println(item.getAttribute("aria-label"));
             if (item.getAttribute("aria-label").contains("nike backpack")){
                 item.click();
             }}}}
