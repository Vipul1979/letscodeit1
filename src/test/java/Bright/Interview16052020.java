package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Interview16052020 {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.britishairways.com/en-gb/flights-and-holidays/flights");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

@Test
    public void britishAirways() throws InterruptedException {
    Actions action = new Actions(driver);
    WebElement moushHoover = driver.findElement(By.linkText("Book"));
    action.moveToElement(moushHoover).perform();

    WebElement bookaFlight = driver.findElement(By.linkText("Book a flight"));
    action.moveToElement(bookaFlight).click().perform();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000);");

    WebElement dropDownHeader = driver.findElement(By.id("depCountry"));
    Select select = new Select(dropDownHeader);
    select.selectByValue("US");

    Thread.sleep(2000);

    js.executeScript("window.scrollBy(0,800);");

    WebElement returDate = driver.findElement(By.xpath("//div[contains(text(),'18')]"));
    returDate.click();

    List<WebElement> allDates = driver.findElements(By.cssSelector(".day-wrapper.bold.ng-scope"));
    for (WebElement date : allDates) {
        System.out.println(date.getText());
        if (date.getText().contains("18")){
            date.click();
        }//if block end
    }//for block end
    }//@Test method end
}//Class end
