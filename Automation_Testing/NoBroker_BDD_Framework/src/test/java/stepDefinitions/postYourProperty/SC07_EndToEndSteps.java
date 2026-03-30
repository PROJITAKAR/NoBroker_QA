package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.AmenitiesPage;
import pageObjects.PostYourProperty.LocalityDetailsPage;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import pageObjects.PostYourProperty.RentalDetailsPage;
import pageObjects.PostYourProperty.SchedulePage;
import pageObjects.PostYourProperty.SuccessPage;
import utils.DriverFactory;

public class SC07_EndToEndSteps {

	WebDriver driver = DriverFactory.getDriver();
	LocalityDetailsPage localityPage = new LocalityDetailsPage(driver);
	AmenitiesPage amenityPage = new AmenitiesPage(driver);
	SchedulePage schedule = new SchedulePage(driver);
	SuccessPage successPage = new SuccessPage(driver);
	PropertyDetailsPage propertyDetail = new PropertyDetailsPage(driver);
	RentalDetailsPage rentalPage = new RentalDetailsPage(driver);

	@When("the user selects {string} as Apartment Type and {string} as BHK")
	public void select_apartment_bhk(String type, String bhk) throws Exception {

		propertyDetail.clickYesButton();
		propertyDetail.selectApartmentType();
		propertyDetail.selectBHK(bhk);
	}

	@When("the user selects {string} as Floor and {string} as Property Age")
	public void select_floor_age(String floor, String age) throws InterruptedException {
		propertyDetail.selectTotalFloor(floor);
		propertyDetail.selectPropertyAge(age);
	}

	@When("the user selects {string} as Facing and enters {string} as Built-up Area in sq ft")
	public void select_facing_area(String facing, String area) throws InterruptedException {
		propertyDetail.selectFacing(facing);
		propertyDetail.enterBuiltUpArea(area);

	}

	@When("the user selects Pune as City and {string} as Locality")
	public void select_city_locality(String locality) throws InterruptedException {
		localityPage.enterLocality(locality);
	}

	@When("the user enters {string} in the Landmark field")
	public void enter_landmark(String landmark) throws InterruptedException {
		localityPage.enterLandmark(landmark);
	}

	@When("the user sets Bathroom count to {string} and Balcony count to {string}")
	public void set_bath_balcony(String bath, String balcony) throws InterruptedException {
		amenityPage.increaseBathroom(2);
		amenityPage.increaseBalcony(2);
	}

	@When("the user enters {string} in the Rent field and {string} in the Deposit field")
	public void enter_rent_deposit(String rent, String deposit) throws InterruptedException {
		rentalPage.enterRent(rent);
		rentalPage.enterDeposit(deposit);
	}

	@When("the user selects {string} as Water Supply and sets {string}, {string}, {string} and {string} to Yes")
	public void select_water_supply(String water, String opt1, String opt2, String opt3, String opt4)
			throws InterruptedException {
		amenityPage.selectWaterSupply();

		amenityPage.selectPetAllowed();

		amenityPage.selectGym();

		amenityPage.selectNonVeg();

		amenityPage.selectGatedSecurity();

	}

	@When("the user selects {string} for {string} and {string} as Property Condition")
	public void select_property_condition(String who, String label, String condition) throws InterruptedException {
		// Who will show property
		amenityPage.selectWhoWillShowProperty();

		// Property condition
		amenityPage.selectPropertyCondition();

	}

	@When("the user selects amenities {string} and {string}")
	public void select_amenities(String a1, String a2) throws InterruptedException {
		amenityPage.selectAmenities();
	}

	@When("the user selects {string} as availability and sets Start Time {string} and End Time {string}")
	public void visit_schedule(String day, String start, String end) throws InterruptedException {
		if (day.equalsIgnoreCase("Everyday")) {
			schedule.selectEveryday();
		}
		// Start Time
		schedule.enterStartTime(start);

		// End Time
		schedule.enterEndTime(end);

	}

	@Then("a success message should be displayed: {string}")
	public void success_message(String msg) {

		String actualMsg = successPage.getSuccessMessageText();

		if (!actualMsg.equalsIgnoreCase(msg)) {
			throw new AssertionError("❌ Expected: " + msg + " but got: " + actualMsg);
		}

		System.out.println("✅ Success message verified: " + actualMsg);
	}

	@Then("the success screen should show options for {string} and {string}")
	public void success_options(String op1, String op2) {

		SuccessPage successPage = new SuccessPage(DriverFactory.getDriver());

		if (!successPage.areOptionsVisible()) {
			throw new AssertionError("❌ Options not visible: " + op1 + ", " + op2);
		}

		System.out.println("✅ Options verified: " + op1 + " & " + op2);
	}
}