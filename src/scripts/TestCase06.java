package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase06 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And validate "SEND" button is displayed and clickable
    And validate button text is displayed as “SEND”
     */
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getTitle().equals("Contact Us | COMFY ELITE")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");

        WebElement sendButton = driver.findElement(By.cssSelector("button[data-aid='CONTACT_SUBMIT_BUTTON_REND']"));

        if(sendButton.isDisplayed() && sendButton.isEnabled()) System.out.println("SEND button validation is passed");
        else throw new NotFoundException("SEND button validation is failed");

        System.out.println("The button text is displayed as = " + sendButton.getText()); // SEND

        if(sendButton.getText().equals("SEND")) System.out.println("SEND button text validation is passed");
        else throw new NotFoundException("SEND button text validation is failed");

        Driver.quitDriver();
    }
}
