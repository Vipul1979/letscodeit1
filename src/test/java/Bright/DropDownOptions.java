package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownOptions {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
    @Test
    public void DropDownDemo() throws InterruptedException {
        WebElement DropDownOption = driver.findElement(By.id("carselect"));
        Select sel = new Select(DropDownOption);

        //select and de-select(if you want) individual element in the dropdown.
        sel.selectByIndex(0);
        Thread.sleep(2000);//Thread.sleep will give you time to see the selection of element.
       //sel.deselectByIndex(0);

        sel.selectByValue("benz");
        Thread.sleep(2000);
        //sel.deselectByValue("benz");

        sel.selectByVisibleText("Honda");

        //List<WebElement> options = sel.getAllSelectedOptions();
        List<WebElement> options = sel.getOptions(); //to get all the options of the select class
        for (WebElement option : options){
            System.out.println(option.getText()); // if you need printout then u must get txt.
        }//for@Test method end

    }
    @Test
    public void multiSelect() throws InterruptedException {

        WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
        Select sel1 = new Select(multiSelect);

        sel1.selectByIndex(0);
        Thread.sleep(2000);
        sel1.selectByVisibleText("Orange");

        sel1.selectByValue("peach");





    }


}


