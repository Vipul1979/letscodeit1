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

public class CalanderExample {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.expedia.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void southhallTravel() {
        WebElement departDate = driver.findElement(By.id("deptdt"));
        departDate.click();

        List<WebElement> calanderDates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement calanderDate : calanderDates) {
            System.out.println(calanderDate.getText());

            if (calanderDate.getText().equals("31")) {
                calanderDate.click();
            }
        }//southhall test method finish


    }

    @Test
    public void expedia() {

        WebElement flightbutton = driver.findElement(By.xpath("//*[@id=\"tab-flight-tab-hp\"]/span[2]"));
        flightbutton.click();

        WebElement departingDate = driver.findElement(By.xpath("//*[@id=\"flight-departing-hp-flight\"]"));
        departingDate.click();

        WebElement mayMonthDate = driver.findElement(By.xpath("//*[@id=\"flight-departing-wrapper-hp-flight\"]/div/div/div[2]/table"));
        mayMonthDate.click();
        System.out.println(mayMonthDate.isDisplayed());//it will give boolean true or false to verify whether hidden element is displayed or not
        //Take all dates in the Lists
        List<WebElement> allDates = mayMonthDate.findElements(By.cssSelector(".datepicker-cal-date"));

        for (WebElement allDate : allDates) {
            System.out.println(allDate.getText());

            if (allDate.getText().contains("7")) {
                allDate.click();
            }
        }
    }
}







