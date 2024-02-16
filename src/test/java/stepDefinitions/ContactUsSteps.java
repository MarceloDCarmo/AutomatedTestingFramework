package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.RandomDataUtils.generateRandomNumber;
import static utils.RandomDataUtils.generateRandomString;

public class ContactUsSteps {

    private final WebDriver driver = DriverFactory.getDriver();

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void iEnterUniqueFirstName() {
        driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void iEnterUniqueLastName() {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void iEnterUniqueEmailAddress() {
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("autoemail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void iEnterUniqueComment() {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Aoba" + generateRandomString(10) + "!");
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithSuccessfulContactSubmissionMessage() {
        WebElement contactUsSubmissionMessage = driver.findElement(By.xpath("//div[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for your Message!");
    }

    @When("I enter a specific first {word}")
    public void iEnterASpecificFirst(String firstName) {
        driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys(firstName);
    }

    @And("I enter a specific last {word}")
    public void iEnterASpecificLast(String lastName) {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(lastName);
    }

    @And("I enter a specific email address {string}")
    public void iEnterASpecificEmailAddress(String emailAddress) {
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(emailAddress);
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(comment);
    }
}
