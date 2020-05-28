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

public class DropDownAutoComplete {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.opodo.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }//@Before method end

    @Test
    public void dropDownAutoCompelet() throws InterruptedException {
        WebElement departfrom = driver.findElement(By.xpath("//*[@id=\"departure-autocomplete0\"]/div[2]/div[3]/div[1]/div[2]/input"));
        System.out.println(departfrom.isDisplayed());
        departfrom.sendKeys("India");
        Thread.sleep(2000);

        List<WebElement> destinations = driver.findElements(By.cssSelector(".item.od-airportselector-suggestions-item"));
        for (WebElement destination : destinations
        ) {
            System.out.println(destination.getText());

            if (destination.getText().contains("Mumbai")) {
                destination.click();
                break;
            }//if statement end
        }//foreach loop end
    }//@Test method end
}//Class end
