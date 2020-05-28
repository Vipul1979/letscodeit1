package BrightHomeWork;

import com.sun.deploy.security.CertificateHostnameVerifier;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalanderSouthHall {

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
        WebElement returnDate = driver.findElement(By.xpath("//input[@name=\"rtndt\"]"));
        returnDate.click();
        Thread.sleep(2000);

        WebElement selectMonth = driver.findElement(By.cssSelector("select[data-handler=selectMonth]"));
        Select sel = new Select(selectMonth);
        //WebElement selectMonth = driver.findElement(By.className("ui-datepicker-month"));
        Thread.sleep(2000);
        sel.selectByIndex(1);

        //td[data-month="5"]

        /*
        List<WebElement> allDates = driver.findElements(By.cssSelector(".ui-datepicker-calendar"));
        for (WebElement date : allDates) {
            System.out.println(date.getText());

            Thread.sleep(2000);
            if (date.getText().contains("26"))
            { date.click();}
        }//for loop end*/
    }//@Test method end
}//Class end
