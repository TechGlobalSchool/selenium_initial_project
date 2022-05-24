package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase03 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And user should be able to see heading2 as "Contact Us"
    And user should be able to see heading4 as "SEND US A MESSAGE"
     */
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getTitle().equals("Contact Us | COMFY ELITE")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");

        WebElement heading2 = driver.findElement(By.cssSelector("h2[data-aid='CONTACT_SECTION_TITLE_REND']>span"));
        WebElement heading4 = driver.findElement(By.cssSelector("h4[data-aid='CONTACT_FORM_TITLE_REND']"));

        if(heading2.getText().equals("Contact Us")) System.out.println("Heading2 validation is passed");
        else throw new NotFoundException("Heading2 is not displayed as expected");

        if(heading4.getText().equals("SEND US A MESSAGE")) System.out.println("Heading4 validation is passed");
        else throw new NotFoundException("Heading4 is not displayed as expected");

        Driver.quitDriver();
    }
}
