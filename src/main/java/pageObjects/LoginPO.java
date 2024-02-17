package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVars;

import static utils.GlobalVars.WEBDRIVER_UNIVERSITY_BASE_URL;

public class LoginPO extends BasePO {
    @FindBy(xpath = "//input[@id=\"text\"]")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id=\"login-button\"]")
    private WebElement loginButton;

    public LoginPO() {
        super();
    }

    public void navigateToWebDriverUniversityLoginPage() {
        navigateToURL(WEBDRIVER_UNIVERSITY_BASE_URL + "/Login-Portal/index.html");
    }

    public void insertUsername(String username) {
        waitAndSendKeys(usernameInput, username);
    }

    public void insertPassword(String password) {
        waitAndSendKeys(passwordInput, password);
    }

    public void clickOnLoginButton() {
        waitAndClick(loginButton);
    }
}
