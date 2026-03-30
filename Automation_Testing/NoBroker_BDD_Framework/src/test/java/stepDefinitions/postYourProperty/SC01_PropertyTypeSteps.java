package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pageObjects.PostYourProperty.StartPostingYourAD;
import utils.DriverFactory;

public class SC01_PropertyTypeSteps {

	WebDriver driver = DriverFactory.getDriver();
	private PageObjectManager pm = new PageObjectManager(driver);

	private StartPostingYourAD startPosting = pm.startPage();

    @When("the user selects Residential as Property Type and Rent as Ad Type and {string} as City")
    public void select_property_type(String city) throws InterruptedException {
        startPosting.clickCityDropDown();
        startPosting.selectCity();
    }
}