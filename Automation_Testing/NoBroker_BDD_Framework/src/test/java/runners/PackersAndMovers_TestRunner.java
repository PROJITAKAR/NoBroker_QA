package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/FeatureFiles",
    glue = {"stepDefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class PackersAndMovers_TestRunner extends AbstractTestNGCucumberTests {
}