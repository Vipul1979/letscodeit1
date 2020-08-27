package BrightPractice;

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

public class Practice18072020 {
    public static WebDriver driver;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void radioButton(){
        WebElement radio = driver.findElement(By.id("bmwradio"));
        radio.click();
    }

    @Test
    public void selectClass(){
        WebElement cars = driver.findElement(By.cssSelector("#carselect"));

        Select select = new Select(cars);

        select.selectByVisibleText("Honda");
        WebElement honda = driver.findElement(By.xpath("//option[contains(text(),'Honda')]"));
        System.out.println(honda.isSelected());
        WebElement bmw = driver.findElement(By.xpath("//option[contains(text(),'BMW')]"));
        System.out.println(bmw.isSelected());
    }
    @Test
    public void multiSelect(){
        WebElement multiSel = driver.findElement(By.cssSelector("#multiple-select-example"));
        Select select = new Select(multiSel);
        select.selectByVisibleText("Apple");
        select.selectByIndex(1);
        select.selectByValue("peach");
        System.out.println(driver.findElement(By.xpath("//option[contains(text(),'Peach')]")).isSelected());
    }

    @Test
    public void checkBox(){
        WebElement checkBoxBMW = driver.findElement(By.id("bmwcheck"));
        checkBoxBMW.click();
        System.out.println(checkBoxBMW.isSelected());
    }
    @Test
    public void mouseHoover() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(1000);

        WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));


        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverButton).perform();

        WebElement secondElement = driver.findElement(By.xpath("//a[contains(text(),'Reload')]"));
        actions.moveToElement(secondElement).click().perform();
    }

}

