package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    @Before("@login")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setBinary("/home/marcelo/Downloads/google-chrome/chrome");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("disable-infobars"); // disabling info bars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-gpu"); // applicable to Windows os only
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

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
