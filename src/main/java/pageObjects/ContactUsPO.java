package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static utils.GlobalVars.WEBDRIVER_UNIVERSITY_BASE_URL;
import static utils.RandomDataUtils.generateRandomNumber;
import static utils.RandomDataUtils.generateRandomString;

public class ContactUsPO extends BasePO {

    @FindBy(xpath = "//input[@name=\"first_name\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name=\"last_name\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//textarea[@name=\"message\"]")
    private WebElement commentInput;

    @FindBy(xpath = "//input[@value=\"SUBMIT\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id=\"contact_reply\"]/h1")
    private WebElement successfulMessageTitle;

    public ContactUsPO() {
        super();
    }

    public void navigateToWebDriverUniversityContactUsPage() {
        navigateToURL(WEBDRIVER_UNIVERSITY_BASE_URL + "/Contact-Us/contactus.html");
    }

    public void insertUniqueFirstName() {
        waitAndSendKeys(firstNameInput, "AutoFN" + generateRandomNumber(5));
    }

    public void insertUniqueLastName() {
        waitAndSendKeys(lastNameInput, "AutoLN" + generateRandomNumber(5));
    }

    public void insertUniqueEmail() {
        waitAndSendKeys(emailInput, "autoemail" + generateRandomNumber(10) + "@mail.com");
    }

    public void insertUniqueComment() {
        waitAndSendKeys(commentInput, "Aoba" + generateRandomString(10) + "!");
    }


    public void insertSpecificFirstName(String firstName) {
        waitAndSendKeys(firstNameInput, firstName);
    }

    public void insertSpecificLastName(String lastName) {
        waitAndSendKeys(lastNameInput, lastName);
    }

    public void insertSpecificEmail(String email) {
        waitAndSendKeys(emailInput, email);
    }

    public void insertSpecificComment(String comment) {
        waitAndSendKeys(commentInput, comment);
    }

    public void clickOnSubmitButton() {
        waitAndClick(submitButton);
    }

    public void validateSuccessfulContactUsSubmissionMessage() {
        waitFor(successfulMessageTitle);
        Assert.assertEquals(successfulMessageTitle.getText(), "Thank You for your Message!");
    }
}
