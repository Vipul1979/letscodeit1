package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice21062020 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.scp.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement lighting = driver.findElement(By.xpath("//a[contains(@class,'menu-item has-submenu')][contains(text(),'Lighting')]"));
        Actions action = new Actions(driver);
        action.moveToElement(lighting).perform();

        WebElement floorlight = driver.findElement(By.xpath("//a[contains(text(),'Floor Lights')]"));
        action.moveToElement(floorlight).click().build().perform();

        List<WebElement> prices = driver.findElements(By.cssSelector(".sale"));
        for (WebElement price:prices
             ) {System.out.println(price.getText());

            Thread.sleep(1000);
             String actual = price.getText().replace("£","");
            double acutalprice;
            acutalprice = Double.parseDouble(actual);
            System.out.println(acutalprice);

            Assert.assertThat(acutalprice, Matchers.greaterThanOrEqualTo(50.00));



        }
    }



}
