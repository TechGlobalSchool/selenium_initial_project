package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase01 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And user should be able to see ComfyElite logo
    And user should be able to see heading2 as “High quality comfy pillows and accessories for travel, office and home."
     */
    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getCurrentUrl().contains("contact-us")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");

        WebElement logo = driver.findElement(By.id("n-48560"));
        WebElement heading2 = driver.findElement(By.id("dynamic-tagline-48605"));

        if(logo.isDisplayed()) System.out.println("Logo validation is passed");
        else throw new NotFoundException("Logo is not displayed");

        if(heading2.getText().equals("High quality comfy pillows and accessories for travel, office and home."))
            System.out.println("Heading2 validation is passed");
        else throw new NotFoundException("Heading2 is not displayed as expected");

        Driver.quitDriver();
    }
}
