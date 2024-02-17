package stepDefinitions.base;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

public class Hooks {
    protected WebDriver driver;

    @Before()
    public void setUp() {
        DriverFactory.getDriver();
    }

    @AfterStep()
    public void captureExceptionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String screenshotName = "Screenshot_" + Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot)DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", screenshotName);
        }
    }

    @After()
    public void tearDown() {
        DriverFactory.cleanupDriver();
    }
}
