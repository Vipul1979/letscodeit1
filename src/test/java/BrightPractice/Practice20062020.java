package BrightPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice20062020 {
    public static WebDriver driver;
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://secure.tesco.com/account/en-GB/login?from=/");
        driver.manage().window().maximize();


    }
}
