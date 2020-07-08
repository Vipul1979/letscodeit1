package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonePriceRangeAssertion {
    public static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.co.uk/s?k=nike&i=shoes&rh=n%3A1769798031%2Cp_36%3A197573031&dc&qid=1592760301&rnid=197571031&ref=sr_nr_p_36_2");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> prices = driver.findElements(By.cssSelector(".a-price"));
        for (WebElement price:prices
             ) {System.out.println(price.getText());

             String acutal = price.getText().replace("£","");
             double actualPrice = Double.parseDouble(acutal);

            System.out.println(actualPrice);
            Assert.assertThat(actualPrice, Matchers.greaterThanOrEqualTo(25.00));
             Assert.assertThat(actualPrice, Matchers.lessThanOrEqualTo(50.00));
        }

    }
}
