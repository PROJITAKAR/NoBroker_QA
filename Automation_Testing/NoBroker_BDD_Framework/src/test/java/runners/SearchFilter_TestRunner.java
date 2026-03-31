package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverFactory;

@CucumberOptions(
    features  = "C:\\Users\\Suvam Nath\\Desktop\\QA\\NoBroker_QA\\Automation_Testing\\NoBroker_BDD_Framework\\src\\test\\resources\\FeatureFiles\\SearchFilter.feature",
    glue      = { "stepDefinitions.Search_Filtering", "hooks" },
    plugin = {
	        "pretty",
	        "html:target/cucumber-reports.html",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    monochrome = true,
	    dryRun = false
	    //tags = "@Regression"
	    //tags = "@Chatbot"
	)
public class SearchFilter_TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {
        // ✅ Store browser globally so any thread can read it
        System.setProperty("browser", browser);
        // ✅ Init driver on this thread
        DriverFactory.initDriver(browser);
    }
}