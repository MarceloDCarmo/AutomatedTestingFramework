package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePO;
import pageObjects.ContactUsPO;

public class ContactUsSteps extends BasePO {

    private final ContactUsPO contactUsPO;

    public ContactUsSteps(ContactUsPO contactUsPO) {
        this.contactUsPO = contactUsPO;
    }

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        contactUsPO.navigateToWebDriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void iEnterUniqueFirstName() {
        contactUsPO.insertUniqueFirstName();
    }

    @And("I enter a unique last name")
    public void iEnterUniqueLastName() {
        contactUsPO.insertUniqueLastName();
    }

    @And("I enter a unique email address")
    public void iEnterUniqueEmailAddress() {
        contactUsPO.insertUniqueEmail();
    }

    @And("I enter a unique comment")
    public void iEnterUniqueComment() {
        contactUsPO.insertUniqueComment();
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        contactUsPO.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithSuccessfulContactSubmissionMessage() {
        contactUsPO.validateSuccessfulContactUsSubmissionMessage();
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        contactUsPO.insertSpecificFirstName(firstName);
    }

    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        contactUsPO.insertSpecificLastName(lastName);
    }

    @And("I enter a specific email address {string}")
    public void iEnterASpecificEmailAddress(String emailAddress) {
        contactUsPO.insertSpecificEmail(emailAddress);
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        contactUsPO.insertSpecificComment(comment);
    }
}
