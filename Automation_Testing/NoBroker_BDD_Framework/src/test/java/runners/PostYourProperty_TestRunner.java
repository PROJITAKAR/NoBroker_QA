package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/FeatureFiles/PostYourProperty",
    glue = {"stepDefinitions", "hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true,
    dryRun = false,
    tags="@Smoke"
)
public class PostYourProperty_TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)  // 🔥 THIS LINE FIXES IT
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
