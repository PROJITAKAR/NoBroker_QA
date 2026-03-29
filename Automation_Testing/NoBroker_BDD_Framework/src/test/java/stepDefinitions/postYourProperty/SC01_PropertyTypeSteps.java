package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.StartPostingYourAD;
import utils.DriverFactory;

public class SC01_PropertyTypeSteps {

    WebDriver driver = DriverFactory.getDriver();
    StartPostingYourAD startPosting = new StartPostingYourAD(driver);

    @When("the user selects Residential as Property Type and Rent as Ad Type and {string} as City")
    public void select_property_type(String city) throws InterruptedException {
        Thread.sleep(1000);
        startPosting.clickCityDropDown();
        Thread.sleep(1000);
        startPosting.selectCity();
        Thread.sleep(1000);
    }
}