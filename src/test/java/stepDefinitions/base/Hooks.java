package stepDefinitions.base;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    protected WebDriver driver;

    @Before()
    public void setUp() {
        DriverFactory.getDriver();
    }

    @After()
    public void tearDown() {
        DriverFactory.cleanupDriver();
    }
}
