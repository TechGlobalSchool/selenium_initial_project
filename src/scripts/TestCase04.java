package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class TestCase04 {
    /*
    Given user navigates to “https://comfyelite.com/”
    When user clicks on “CONTACT US” link in the header
    Then user should be navigated to “CONTACT US” page
    And validate "First Name" input box
    And validate "Last Name" input box
    And validate "Email" input box
    And validate "Message" input box

    NOTE: Input validation includes input being displayed and user being able send keys to input box.
    It also requires validating the given labels and placeholders

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();

        driver.get("https://comfyelite.com/");

        WebElement contactUsLink = driver.findElement(By.xpath("//a[text()='Contact Us']"));
        contactUsLink.click();

        if(driver.getTitle().equals("Contact Us | COMFY ELITE")) System.out.println("User is on Contact Us page");
        else throw new NotFoundException("User is not routed to Contact Us page");

        WebElement firstNameInputBox = driver.findElement(By.xpath("((//form)[2]/div//input)[1]"));
        WebElement lastNameInputBox = driver.findElement(By.xpath("((//form)[2]/div//input)[2]"));
        WebElement emailInputBox = driver.findElement(By.xpath("((//form)[2]/div//input)[3]"));
        WebElement firstNameInputLabel = driver.findElement(By.xpath("((//form)[2]/div//label)[1]"));
        WebElement lastNameInputLabel = driver.findElement(By.xpath("((//form)[2]/div//label)[2]"));
        WebElement emailInputLabel = driver.findElement(By.xpath("((//form)[2]/div//label)[3]"));
        WebElement messageTextBox = driver.findElement(By.tagName("textarea"));

        if(firstNameInputBox.isDisplayed() && firstNameInputLabel.getText().equals("First Name*")) System.out.println("First name input box is displayed as expected");
        else throw new NotFoundException("First name input is not displayed as expected");

        String firstName = "John";
        firstNameInputBox.sendKeys(firstName);
        if(firstNameInputBox.getAttribute("value").equals(firstName)) System.out.println("Value sent to first name is displayed as expected");
        else throw new NotFoundException("Value sent to first name input box is not displayed as expected");


        if(lastNameInputBox.isDisplayed() && lastNameInputLabel.getText().equals("Last Name*")) System.out.println("Last name input box is displayed as expected");
        else throw new NotFoundException("Last name input is not displayed as expected");

        String lastName = "Doe";
        lastNameInputBox.sendKeys(lastName);
        if(lastNameInputBox.getAttribute("value").equals(lastName)) System.out.println("Value sent to last name is displayed as expected");
        else throw new NotFoundException("Value sent to last name input box is not displayed as expected");


        if(emailInputBox.isDisplayed() && emailInputLabel.getText().equals("Email*")) System.out.println("Email input box is displayed as expected");
        else throw new NotFoundException("Email input is not displayed as expected");

        String email = "johndoe@gmail.com";
        emailInputBox.sendKeys(email);
        if(emailInputBox.getAttribute("value").equals(email)) System.out.println("Value sent to email is displayed as expected");
        else throw new NotFoundException("Value sent to email input box is not displayed as expected");


        if(messageTextBox.isDisplayed() && messageTextBox.getAttribute("placeholder").equals("Message*")) System.out.println("Message text box is displayed as expected");
        else throw new NotFoundException("Message text box is not displayed as expected");

        String message = "Hello World";
        messageTextBox.sendKeys(message);

        if(messageTextBox.getText().equals(message)) System.out.println("Value sent to message text box is displayed as expected");
        else throw new NotFoundException("Value sent to message text box is not displayed as expected");

        Thread.sleep(5000);
        Driver.quitDriver();
    }
}
