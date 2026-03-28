package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import utils.DriverFactory;

public class SC02_PropertyDetailsSteps {

    WebDriver driver = DriverFactory.getDriver();
    PropertyDetailsPage propertyDetail = new PropertyDetailsPage(driver);

    @When("the user selects {string} as Apartment Type and {string} as BHK")
    public void select_apartment_bhk(String type, String bhk) throws Exception {

        Thread.sleep(8000);
        propertyDetail.clickYesButton();

        Thread.sleep(1000);
        propertyDetail.selectApartmentType();
        Thread.sleep(1000);
        propertyDetail.selectBHK();
        Thread.sleep(1000);
    }

    @When("the user selects {string} as Floor and {string} as Property Age")
    public void select_floor_age(String floor, String age) throws InterruptedException {
        Thread.sleep(1000);
        propertyDetail.selectTotalFloor();
        Thread.sleep(1000);
        propertyDetail.selectPropertyAge();
        Thread.sleep(1000);
    }

    @When("the user selects {string} as Facing and enters {string} as Built-up Area in sq ft")
    public void select_facing_area(String facing, String area) throws InterruptedException {
        Thread.sleep(1000);
        propertyDetail.selectFacing();
        Thread.sleep(1000);
        propertyDetail.enterBuiltUpArea(area);
    }
}