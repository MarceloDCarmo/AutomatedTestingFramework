package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
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

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class LoginSteps {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setBinary("/home/marcelo/Downloads/google-chrome/chrome");
        chromeOptions.addArguments("disable-infobars"); // disabling info bars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-gpu"); // applicable to Windows os only
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver login page")
    public void iAccessTheWebdriverLoginPage() {
        driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a valid username")
    public void iEnterAValidUsername() {
        driver.findElement(By.xpath("//input[@id=\"text\"]")).sendKeys("webdriver");
    }

    @And("I enter a valid password")
    public void iEnterAValidPassword() {
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("webdriver123");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//button[@id=\"login-button\"]")).click();
    }

    @Then("I should be presented with an alert informing a successful login")
    public void iShouldBePresentedWithAnAlertInformingASuccessfulLogin() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();

        Assert.assertEquals(message, "validation succeeded");

        alert.accept();
    }

    @When("I enter a invalid username")
    public void iEnterAInvalidUsername() {
        driver.findElement(By.xpath("//input[@id=\"text\"]")).sendKeys(randomAlphabetic(5) + randomNumeric(5));
    }

    @And("I enter a invalid password")
    public void iEnterAInvalidPassword() {
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(randomAlphabetic(5) + randomNumeric(5));
    }

    @Then("I should be presented with an alert informing I have failed to login")
    public void iShouldBePresentedWithAnAlertInformingIHaveFailedToLogin() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();

        Assert.assertEquals(message, "validation failed");

        alert.accept();
    }
}
