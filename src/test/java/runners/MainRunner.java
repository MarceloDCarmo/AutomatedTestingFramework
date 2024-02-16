package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/reports/cucumber.html", "json:target/reports/cucumber.json"},
        tags = "@regression")
public class MainRunner extends AbstractTestNGCucumberTests {
}
