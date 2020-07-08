package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceRangeAssertion {
    public static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.className("_1Rz0y"));
        searchBox.sendKeys("nike");

        WebElement searchButton = driver.findElement(By.className("_1gqeQ"));
        searchButton.click();

        WebElement fiveto10Price = driver.findElement(By.xpath("//label[@id='filter-price-£5 - £10-label']//div[@class='Checkboxstyles__CheckboxOption-e3lxpy-3 esYLSA']//*[local-name()='svg']"));
        fiveto10Price.click();

        List<WebElement> prices = driver.findElements(By.cssSelector(".ProductCardstyles__PriceContainer-l8f8q8-13.lcxskn"));
        for (WebElement price:prices
             ) {System.out.println(price.getText());

             String actual = price.getText().replace("£","");
             double actualPrice = Double.parseDouble(actual);
             System.out.println(actualPrice);

            Assert.assertThat(actualPrice, Matchers.greaterThanOrEqualTo(5.00));
            Assert.assertThat(actualPrice,Matchers.lessThanOrEqualTo(10.00)); }}}
