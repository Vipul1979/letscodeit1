package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AssertionDemo {

    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }//Before method end

    @Test
    public void argos(){
        String actual = driver.getCurrentUrl(); //actual write here
       // Assert.assertThat(actual,Matchers.endsWith("argos.co.uk/"));//expexted write here this one will be pass
        //Assert.assertThat(actual, Matchers.equalToIgnoringCase("https://www.argos.co.uk/")); //expexted write here , this one will be pass
        //Assert.assertThat(actual, Matchers.equalToIgnoringCase("https://www.argos1.co.uk/")); //expexted write here , this one will be fail as argose1
        //Assert.assertThat(actual,Matchers.containsString("https://www.argos.co.uk/"));

        // Five different importatn method for assertion
        //Assert.assertThat(actual,Matchers.endsWith("co.uk"));
        //Assert.assertThat(actual,Matchers.containsString("nike mens"));
        //Assert.assertThat(actual,Matchers.equalToIgnoringCase("argose.co.uk"));
        //Assert.assertThat(actual,Matchers.greaterThanOrEqualTo("5.00"));
        //Assert.assertThat(actual,Matchers.lessThanOrEqualTo("10.00"));
    }


}
