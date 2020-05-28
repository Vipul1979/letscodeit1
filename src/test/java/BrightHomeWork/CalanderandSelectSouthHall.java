package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalanderandSelectSouthHall {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.southalltravel.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void calanderSouthHall() throws InterruptedException {
        WebElement returnDate = driver.findElement(By.id("rtndt"));
        returnDate.click();

        Thread.sleep(2000);
        List<WebElement> allDates = driver.findElements(By.cssSelector("td[data-month=\"4\"]"));
        for (WebElement date : allDates) {
           System.out.println(date.getAttribute(""));
            // System.out.println(date.getText());

           /* if (date.getText().contains("26")){
                date.click();}*/
        }
    }
}
