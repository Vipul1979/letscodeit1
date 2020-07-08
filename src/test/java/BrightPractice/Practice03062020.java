package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice03062020 {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.opodo.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }//@Befor method finish

    @Test
    public void calanderClick() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        Thread.sleep(1000);
        WebElement departure = driver.findElement(By.className("od-ui-datepicker-display"));
        departure.click();

        Thread.sleep(2000);
        WebElement julyMonth = driver.findElement(By.xpath("//*[@id=\"flights-manager\"]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]"));

        List<WebElement> julyDates = julyMonth.findElements(By.cssSelector(".od-ui-calendar-day"));
        for (WebElement julyDate : julyDates
        ) {
            System.out.println(julyDate.getText());

            if (julyDate.getText().contains("25")) {
                julyDate.click();
                break;
            }//if block end
        }//foreach loop end
    }//@Test method end
    @After
    public void tearDown() throws InterruptedException {
        // Thread.sleep(2000);
        //driver.quit();
    }//@After method end
}//Practice03062020 class end
