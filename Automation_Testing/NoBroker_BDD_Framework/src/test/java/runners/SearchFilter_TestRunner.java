package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "C:\\Users\\Suvam Nath\\Desktop\\QA\\NoBroker_QA\\Automation_Testing\\NoBroker_BDD_Framework\\src\\test\\resources\\FeatureFiles\\SearchFilter.feature",
glue = {"stepDefinitions","hooks"},                

    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },

    monochrome = true
)

public class SearchFilter_TestRunner extends AbstractTestNGCucumberTests {
	
}