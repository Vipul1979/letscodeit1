package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutocompeleteDropdown {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.expedia.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void expedia() throws InterruptedException {
        WebElement destinationfield = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']"));
        System.out.println(destinationfield.isEnabled()); //boolean answer : true
        destinationfield.sendKeys("Del");
        Thread.sleep(2000);


        List<WebElement> destinations = driver.findElements(By.cssSelector(".results-item")); //css converted from class name
        //List<WebElement> destinations = driver.findElements(By.cssSelector(".multiLineDisplay.details")); // css converted from another class name
        //List<WebElement> destinations = driver.findElements(By.cssSelector("li[class=results-item]")); //css by tagename and same one with .results-item
        for (WebElement destination : destinations) {
            System.out.println(destination.getText());

            // if (destination.getText().contains("Delhi (DEL - Indira Gandhi Intl.)")) {
            if (destination.getText().contains("India")) {
                destination.click();
                break;
            }
        }
    }
}
