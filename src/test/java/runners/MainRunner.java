package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/reports/cucumber.html", "json:target/reports/cucumber.json"},
        tags = "@login")
public class MainRunner extends AbstractTestNGCucumberTests {
}
