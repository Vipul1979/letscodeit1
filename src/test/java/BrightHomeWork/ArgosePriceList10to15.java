package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArgosePriceList10to15 {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void selectpriceList10to15() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("Nike");

        WebElement serchButton = driver.findElement(By.className("_1gqeQ"));
        serchButton.click();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600);");

        Thread.sleep(2000);
        List<WebElement> priceLists = driver.findElements(By.cssSelector("label[name=price]"));//(".Checkboxstyles__LabelValue-e3lxpy-6.fOQrQk"));//(".findability-facet__filters.findability-facet__filters--default"));//(".Checkboxstyles__CheckboxOption-e3lxpy-3.esYLSA"));
        for (WebElement priceList : priceLists) {
            //System.out.println(priceList.getText());
            System.out.println(priceList.getAttribute("value"));

            Thread.sleep(2000);
            //if (priceList.getText().contains("£10 - £15"))
            if (priceList.getAttribute("value").contains("£10 - £15")) {
                priceList.click();
            }
        }
    }
}
