package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePO;
import pageObjects.LoginPO;

public class LoginSteps extends BasePO {

    private final LoginPO loginPO;

    public LoginSteps(LoginPO loginPO) {
        this.loginPO = loginPO;
    }

    @Given("I access the webdriver login page")
    public void iAccessTheWebdriverLoginPage() {
        loginPO.navigateToWebDriverUniversityLoginPage();
    }

    @When("I enter the username {word}")
    public void iEnterAInvalidUsername(String username) {
        loginPO.insertUsername(username);
    }

    @And("I enter the password {}")
    public void iEnterAInvalidPassword(String password) {
        loginPO.insertPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPO.clickOnLoginButton();
    }

    @Then("I should be presented with an alert with the message {string}")
    public void iShouldBePresentedWithAnAlertInformingLoginStatus(String message) {
        waitForAlertAndValidateText(message);
    }
}
