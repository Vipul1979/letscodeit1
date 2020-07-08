package BrightPractice;

import gherkin.lexer.Th;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Practice29052020 {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/p/practice");  //mouseHooverAction
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

    @Test
    public void mouseHooverAction() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        WebElement mouseElement = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseElement).perform();
        WebElement topElement = driver.findElement(By.linkText("Top"));
       Thread.sleep(2000);
        actions.moveToElement(topElement).click().perform();
    }//@Test for mouseHooverAction method end

    @Test
    public void selectDemo() throws InterruptedException {
        WebElement selectElement = driver.findElement(By.id("carselect"));
        Select select = new Select(selectElement);
        Thread.sleep(2000);
        select.selectByValue("bmw");
        Thread.sleep(2000);
        select.selectByVisibleText("Benz");
        Thread.sleep(2000);
        select.selectByIndex(2);
    }//@Test selectDemo method end

    @Test
    public void multiSelectDemo() throws InterruptedException {
        WebElement multiSelectElement =driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiSelectElement);
        select.selectByVisibleText("Apple");
        Thread.sleep(2000);
        select.deselectByVisibleText("Apple");


        select.selectByValue("orange");
        Thread.sleep(2000);
        select.deselectByValue("orange");

        Thread.sleep(2000);
        select.selectByIndex(2);
    }//@Test multiSelect method end

    @Test
    public void checkBox () throws InterruptedException {
        WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
        WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
        WebElement hondaCheckbox = driver.findElement(By.id("hondacheck"));

        bmwCheckBox.click();
        benzCheckBox.click();
        hondaCheckbox.click();

        Thread.sleep(2000);
        benzCheckBox.click();
        Thread.sleep(2000);
        System.out.println(benzCheckBox.isSelected()); //answer is in Boolean false

    }//@Test checkBox method end

    @Test
    public void assertCurrentURL(){
        String actualURL = driver.getCurrentUrl();
        Assert.assertThat(actualURL, Matchers.containsString("https://letskodeit.teachable.com/p/practice"));

    }//@Test assertCurrentURL method end

    @Test
    public void keyPressEvent() throws InterruptedException {
        WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
        bmwRadio.click();
        bmwRadio.sendKeys(Keys.CONTROL + "a",Keys.CONTROL + "c");

        Thread.sleep(2000);
        WebElement enterYourName = driver.findElement(By.className("inputs"));
        enterYourName.click();
        enterYourName.sendKeys(Keys.CONTROL + "v");
    }//@Test keyPressEvent method end

    @Test
    public void switchIframe() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1400)");

        Thread.sleep(1000);
        driver.switchTo().frame("courses-iframe");

        WebElement findCourse = driver.findElement(By.id("search-courses"));
        findCourse.sendKeys("Java");

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
        bmwRadioButton.click();
    }

    @After
    public void tearDown(){
        //driver.quit();//to close everything
        //driver.close();//to close current window
    }
}//Class end
