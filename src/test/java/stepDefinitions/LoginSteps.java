package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @Given("I access the webdriver login page")
    public void iAccessTheWebdriverLoginPage() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter the username {word}")
    public void iEnterAInvalidUsername(String username) {
        driver.findElement(By.xpath("//input[@id=\"text\"]")).sendKeys(username);
    }

    @And("I enter the password {}")
    public void iEnterAInvalidPassword(String password) {
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//button[@id=\"login-button\"]")).click();
    }

    @Then("I should be presented with an alert with the message {string}")
    public void iShouldBePresentedWithAnAlertInformingIHaveFailedToLogin(String message) {
        //Another approach:
        //Alert alert = driver.switchTo().alert();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();

        Assert.assertEquals(alertMessage, message);

        alert.accept();
    }
}
