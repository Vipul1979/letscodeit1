package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class argosElements {
public static WebDriver driver;
// or you can give any different name to driver. like  public static WebDriver driver1;
    public static void main(String []args){
       // System.setProperty("webdriver.chrome.driver","C:\\Program Files\\selenium-java-2.53.1\\selenium-2.53.1\\libs\\chromedriver_win32\\chromedriver.exe;")
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32 (1)\\chromedriver_win32 version 81\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.argos.co.uk/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement searchbox = driver.findElement(By.id("searchTerm"));
        //find search box element by ID

        //WebElement searchbox = driver.findElement(By.xpath("/html//input[@id='searchTerm']"));
        searchbox.sendKeys("Nike");

        WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"haas-v2\"]/div[2]/div/div[3]/div/form/button/span[2]"));
        searchbutton.click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/search?q=%22https%3A%2F%2Fwww.argos.co.uk%2F%22&oq=%22https%3A%2F%2Fwww.argos.co.uk%2F%22&aqs=chrome..69i57j0j5l6.1054j0j8&sourceid=chrome&ie=UTF-8");
        driver.navigate().back();
        driver.navigate().forward();
        //searchbox.clear();
       // WebElement searchbox = driver.findElement(By.cssSelector("#searchTerm"));

        /*searchbox.sendKeys("adidas");
        searchbutton.click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); */

        driver.quit();
       // WebElement wishlistButton = driver.findElement(By.linkText("Wishlist"));
       // wishlistButton.click();

        //WebElement accountButton = driver.findElement(By.linkText("Account"));
        //accountButton.click();

        //WebElement trollyButton = driver.findElement(By.linkText("Trolley"));
        //trollyButton.click();
    } // main method end
} // class end
