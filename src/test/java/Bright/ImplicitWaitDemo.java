package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitDemo {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.get("https://learn.letskodeit.com/");
        driver.get("https://www.argos.co.uk/account/login?clickOrigin=header:home:account");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //NoSuchElementException: no such element: Unable to locate element: and test fail
        //it will applied in all test
    }// set up method end
    @Test
    public void implicit() {
        WebElement logIn = driver.findElement(By.linkText("Login"));
        logIn.click();

        WebElement userName = driver.findElement(By.id("user_email"));
        userName.sendKeys("test");
    }//Implicit method end


    @Test
    public void explicit(){
        WebElement logIn = driver.findElement(By.linkText("Login"));
        logIn.click();
                                                //driver instance
        WebDriverWait wait = new WebDriverWait(driver,3);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        userName.sendKeys("test");
    }//Explicit method end
    @Test
    public void explicit1(){
        WebElement username = driver.findElement(By.id("email-address"));
        username.sendKeys("vipul@gmail.com");
        WebElement password = driver.findElement(By.id("current-password"));
        password.sendKeys("swami1234");

        WebDriverWait wait = new WebDriverWait(driver,3); //driver instance
        WebElement signInSecurly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button")));
        signInSecurly.click();

    }
}//class end


