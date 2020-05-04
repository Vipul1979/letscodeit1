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

public class MultiSelectExample {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void multiSelectElement() throws InterruptedException {
        WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
        Select sel = new Select(multiSelect);

        Thread.sleep(3000);
        //Select multiple element one by on
        sel.selectByValue("apple");
        sel.selectByVisibleText("Orange");
        sel.selectByIndex(2);

        Thread.sleep(3000);
        //now deselect peach and apple
        sel.deselectByValue("peach");
        sel.deselectByIndex(0);

        //Exptra practice take it in list and print all then click on Apple
        List<WebElement> options = sel.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());

           //Make sure copy Apple word from console and not from website
            if (option.getText().contains("Apple"));
            option.click();
        }//foreach loop end
    }//@Test method end
}//MultiSelectExample Class end
