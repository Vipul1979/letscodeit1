package BrightHomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragandDrop {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }//@Before method end

    @Test
    public void dragable(){
        driver.switchTo().frame(0);

        WebElement dragFrom = driver.findElement(By.id("draggable"));
        WebElement dropTo =  driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver); // Actions from org.openqa.selenium.interactions.Actions
        action.dragAndDrop(dragFrom,dropTo).build().perform();
        //dragAndDrop(dragFrom(source),dropTo(target))
        //driver.switchTo().defaultContent();
    }//@Test method end



}
