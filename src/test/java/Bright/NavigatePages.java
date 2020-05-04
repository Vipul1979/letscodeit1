package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigatePages {
    // Declaring static variable
    public static WebDriver driver;

    @Before
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32 (1)\\chromedriver_win32 version 81\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.tesco.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.get("https://learn.letskodeit.com/p/practice");
        //driver.get("https://learn.letskodeit.com/");
        driver.manage().window().maximize();
    } //setup method end

    @Test
    public void test1() {
        String CurrentTitle = driver.getTitle(); //CurrentTitle always in String
        System.out.println(CurrentTitle);

        String CurrentURL = driver.getCurrentUrl();
        System.out.println(CurrentURL); // it  will print home page URL https://learn.letskodeit.com/

        driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
        String NavigateUrl = driver.getCurrentUrl();
        System.out.println(NavigateUrl);

        driver.navigate().back();
        driver.navigate().forward();

       /* driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#user_email")).sendKeys("bhesaniav@gmail.com");

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("bhesania");

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[4]/input")).click();

        driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
        driver.quit(); */
    }// test 1 method end

    @Test
    public void test2() {
        WebElement acceptClosePrivacy = driver.findElement(By.xpath("//*[@id=\"cookie-policy\"]/button/span[1]"));
        acceptClosePrivacy.click();

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        WebElement searchBox = driver.findElement(By.xpath("//div[@class='search-logo-container']//input[@placeholder='Search']"));
        searchBox.sendKeys("Cheese");

        WebElement searchButton = driver.findElement(By.xpath("//div[@class='search-logo-container']//span[@class='ui-icon']"));
        searchButton.click();

        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/span/div/section/form/button/span[1]"));
        closeButton.click();

        WebElement addCheaderCheese = driver.findElement(By.xpath("//*[@id=\"tile-268768873\"]/div[2]/form/div/div[2]/button/span[1]"));
        addCheaderCheese.click();

        WebElement emailEnter = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailEnter.sendKeys("cheadertoBasket@gmail.com");

        WebElement passworEnter = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passworEnter.sendKeys("addchedder");

        WebElement clickSignIn = driver.findElement(By.xpath("//*[@id=\"sign-in-form\"]/button/span"));
        clickSignIn.click();

    }
        @Test
    public void test3(){
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        System.out.println("****Now it will print sign in page Title and Url different URL****");

        driver.navigate().to("https://secure.tesco.com/account/en-GB/login?from=/");
        String currentTitle1 = driver.getTitle();
        System.out.println(currentTitle1);

        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);

        driver.navigate().back();
        System.out.println("tesco url");
        driver.navigate().forward();
        System.out.println("sign in url");
        driver.navigate().back();
        System.out.println("Back to home page url and refresh");
        driver.navigate().refresh();

        }
    /*@Before
    public void closeBrowser() {
        driver.quit();

    }*///@Before method end
}//Class end

