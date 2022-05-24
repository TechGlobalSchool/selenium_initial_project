package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase02 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And user should be able to see heading1 as "Connect With Us"
    And user should be able to see “Facebook” icon and hyperlink reference for it should be “https://www.facebook.com/103179127717601”
    And user should be able to see “Instagram” icon and hyperlink reference for it should be “https://www.instagram.com/comfyelite”

     */
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getTitle().contains("Contact Us")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");

        WebElement heading1 = driver.findElement(By.tagName("h1"));
        WebElement facebookIcon = driver.findElement(By.xpath("//div[@data-aid='SOCIAL_SOCIAL_LINKS']/a[1]"));
        WebElement instagramIcon = driver.findElement(By.xpath("//div[@data-aid='SOCIAL_SOCIAL_LINKS']/a[2]"));

        if(heading1.getText().equals("Connect With Us")) System.out.println("Heading1 validation is passed");
        else throw new NotFoundException("Heading1 is not displayed as expected");

        if(facebookIcon.isDisplayed() && facebookIcon.getAttribute("href").equals("https://www.facebook.com/103179127717601"))
            System.out.println("Facebook icon validation is passed");
        else throw new NotFoundException("Facebook icon not displayed as expected");

        if(instagramIcon.isDisplayed() && instagramIcon.getAttribute("href").equals("https://www.instagram.com/comfyelite"))
            System.out.println("Instagram icon validation is passed");
        else throw new NotFoundException("Instagram icon not displayed as expected");

        Driver.quitDriver();
    }
}
