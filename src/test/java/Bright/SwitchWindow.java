package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void Switch() throws InterruptedException {

        //Savig orgos window handle
        String argosHandle = driver.getWindowHandle();
        System.out.println(argosHandle);

        //Opening another tab with facebok url
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0])", "https://en-gb.facebook.com/");

        Thread.sleep(20000);

        //set both open windows handle
        Set<String> handles = driver.getWindowHandles();

        //for-each loop to print both window handles, if block to switch on second window

        for (String handle : handles) {
            if (!handle.equals(argosHandle)) {
                driver.switchTo().window(handle);
                System.out.println(handle); //CDWindow-and mixture of alphabet and number that is the name

            }//if block end
        }//if llp end

        String facebookHandle = driver.getWindowHandle();

        Thread.sleep(2000);

        driver.switchTo().window((argosHandle));

        Thread.sleep(2000);

        driver.switchTo().window(facebookHandle);
    }

}
