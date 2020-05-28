package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static Bright.NavigatePages.driver;


public class RadioButton {
    public static WebDriver driver;

    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32 (1)\\chromedriver_win32 version 81\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void RadioButton() {
        WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
        bmwRadioButton.click();
        System.out.println(bmwRadioButton.isSelected());

        WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
        benzRadioButton.click();
        // System.out.println(bmwRadioButton.isSelected()); // isselected method will give boolean result false
        System.out.println(benzRadioButton.isSelected()); // boolean answer True
        //radio button at a time select only one button thats why it give first answer false
    } // RadioButton method end

    @After
    public void teardown90() {
        //driver.quit(); //to close all open window everything close
        //driver.close(); // to close on current window
    }//After method end
}//class end
