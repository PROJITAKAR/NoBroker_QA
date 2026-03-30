package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverFactory;

@CucumberOptions(
	features = "src/test/resources/FeatureFiles/EPC",
    glue = {"stepDefinitions", "hooks"},
    		plugin = {
    		        "pretty",
    		        "html:target/cucumber-reports.html",
    		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)
public class EPC_TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
	    DriverFactory.initDriver(browser);
	}
}