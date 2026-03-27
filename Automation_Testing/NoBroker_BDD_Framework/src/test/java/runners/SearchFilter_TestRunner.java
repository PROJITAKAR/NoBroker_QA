package runnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

    features = "D:\\capgemini OOPS QUESTIONS\\sprint\\Capgemini_Sprint_NoBroker\\Automation_Testing\\NoBroker_BDD_Framework\\src\\test\\java\\FeatureFile\\NoBroker.feature",   // path to feature file
    glue = "StepDefinition",                 // where step defs are

    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },

    monochrome = true
)

public class SearchFilter_TestRunner extends AbstractTestNGCucumberTests {
	
}