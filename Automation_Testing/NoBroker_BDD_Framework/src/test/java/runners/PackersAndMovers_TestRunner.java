package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverFactory;

@CucumberOptions(
    features = "src/test/resources/FeatureFiles/PackersAndMovers",
    glue = {"stepDefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class PackersAndMovers_TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
	    DriverFactory.initDriver(browser);
	}
}