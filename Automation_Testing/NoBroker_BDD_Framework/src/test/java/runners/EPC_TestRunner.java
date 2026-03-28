package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/FeatureFiles/EPC.feature",
    glue = {"stepDefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    tags = "@LoginRequired and @RunThis"
)
public class EPC_TestRunner extends AbstractTestNGCucumberTests {
}