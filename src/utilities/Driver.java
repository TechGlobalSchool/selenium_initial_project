package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    private Driver(){

    }

    public static WebDriver getDriver(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            /*
            WHY DO WE NEED THIS IMPLICIT WAIT
            -This implicit wait applies to each line that locates web elements
            -findElement() or findElements() 60 times -> NoSuchElementException
            -500 milliseconds
             */
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}
