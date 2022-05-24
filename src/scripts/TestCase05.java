package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase05 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And validate the "Sign up for our email list for updates, promotions, and more." checkbox
    Note: Checkbox validation includes checkbox being selected and deselected by user

    1. Make sure it is deselected by default
    2. Click on it and make sure it is selected now
    3. Click on it one more time and make sure it is deselected again
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getTitle().equals("Contact Us | COMFY ELITE")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");


        WebElement checkBoxInput = driver.findElement(By.xpath("//label[@data-ux='InputCheckbox']/input"));
        WebElement checkBoxDiv = driver.findElement(By.xpath("//label[@data-ux='InputCheckbox']/div"));

        //Default - deselected
        if(!checkBoxInput.isSelected()) System.out.println("Check box is not selected by default");
        else throw new NotFoundException("Check box is selected by default");

        Thread.sleep(2000);
        checkBoxDiv.click();

        //Make sure it is selected
        if(checkBoxInput.isSelected()) System.out.println("Check box is selected after the click");
        else throw new NotFoundException("Check box is not selected after the click");

        Thread.sleep(2000);
        checkBoxDiv.click();

        //Make sure it is deselected again
        if(!checkBoxInput.isSelected()) System.out.println("Check box is deselected after the second click");
        else throw new NotFoundException("Check box is not getting deselected after the second click");

        Driver.quitDriver();
    }
}
