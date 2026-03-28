package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverFactory;

@CucumberOptions(
    features = "src/test/resources/FeatureFiles/PostYourProperty",
    glue = {"stepDefinitions.postYourProperty", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    dryRun = false,
    tags="@Smoke"
)
public class PostYourProperty_TestRunner extends AbstractTestNGCucumberTests{
//	@Override
//    @DataProvider(parallel = false)  // 🔥 THIS LINE FIXES IT
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
	    DriverFactory.initDriver(browser);
	}
}
