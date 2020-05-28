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

public class CalanderExpedia {
    public static WebDriver driver;
    //button[data-month="5"]
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.expedia.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void twoHiddenMonth() throws InterruptedException {
        WebElement checkIndate = driver.findElement(By.id("hotel-checkin-hp-hotel"));
        checkIndate.click();

        WebElement juneMonthDate = driver.findElement(By.cssSelector(".datepicker-cal-date"));
        System.out.println(juneMonthDate.isDisplayed());

        Thread.sleep(2000);
        List<WebElement> juneAllDats = driver.findElements(By.cssSelector("button[data-month=\"5\"]"));
        for (WebElement juneDate : juneAllDats
             ) {System.out.println(juneDate.getText());

            /* if (juneDate.getAttribute("value").contains("20"));
             juneDate.click();*/

        }

    }

}
