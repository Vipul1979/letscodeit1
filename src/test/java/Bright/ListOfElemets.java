package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOfElemets {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void RadioButton() {
        List<WebElement> radiobuttons = driver.findElements(By.cssSelector("input[type=radio]"));

        for (WebElement radiobutton : radiobuttons) {
            System.out.println(radiobutton.getAttribute("value"));
           // System.out.println(radiobutton.getText()); //can print bmw benz honda
            //radiobutton.click();

           //make sure to copy benz word from console and not from website
            if (radiobutton.getAttribute("value").contains("benz"))
            // if (radiobutton.getText().contains("Benz"));
                radiobutton.click();//it will click on benz only
            //if loop end
   /* @Test void checkBox (){
                List<WebElement> checkbox = driver.findElements(By.cssSelector())*/
        }
    }//for-each loop end
}


