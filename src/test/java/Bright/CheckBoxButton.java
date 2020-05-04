package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxButton {
    public static WebDriver driver;
    @Before
            public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32 (1)\\chromedriver_win32 version 81\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
    }

        @Test
               public void checkBox(){

            WebElement checkboxBmw = driver.findElement(By.id("bmwcheck"));
            checkboxBmw.click();

            WebElement checkboxHonda = driver.findElement(By.id("honda"));
            checkboxHonda.click();

        }

        }



