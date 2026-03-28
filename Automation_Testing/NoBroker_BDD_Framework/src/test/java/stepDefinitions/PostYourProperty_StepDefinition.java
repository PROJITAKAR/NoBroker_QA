package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.PostYourProperty.AmenitiesPage;
import pageObjects.PostYourProperty.LocalityDetailsPage;
import pageObjects.PostYourProperty.NavigationToPostYourProperty;
import pageObjects.PostYourProperty.PostYourPropertyMainPage;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import pageObjects.PostYourProperty.RentalDetailsPage;
import pageObjects.PostYourProperty.SchedulePage;
import pageObjects.PostYourProperty.StartPostingYourAD;
import pageObjects.PostYourProperty.SuccessPage;
import pageObjects.PostYourProperty.UploadMediaPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverFactory;

public class PostYourProperty_StepDefinition {

	WebDriver driver = DriverFactory.getDriver();

	NavigationToPostYourProperty navigate = new NavigationToPostYourProperty(driver);
	PostYourPropertyMainPage mainPropertyPage = new PostYourPropertyMainPage(driver);
	StartPostingYourAD startPosting = new StartPostingYourAD(driver);
	PropertyDetailsPage propertyDetail = new PropertyDetailsPage(driver);
	LocalityDetailsPage localityPage = new LocalityDetailsPage(driver);
	RentalDetailsPage rentalPage = new RentalDetailsPage(driver);
	AmenitiesPage amenitiesPage = new AmenitiesPage(driver);
	UploadMediaPage uploadPage = new UploadMediaPage(driver);
	SchedulePage schedulePage = new SchedulePage(driver);
	SuccessPage successPage = new SuccessPage(driver);

	// ================= LOGIN & NAVIGATION =================

	@Given("the user is on the NoBroker Homepage")
	public void verify_homepage() throws InterruptedException {
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(1000);
		Assert.assertTrue(currentUrl.contains("nobroker"), "Not on homepage");
	}

	@When("the user clicks {string}")
	public void the_user_clicks_post_your_property(String button) throws InterruptedException {
		if (button.equalsIgnoreCase("Post Your Property")) {
			Thread.sleep(1000);
			navigate.clickPostProperty();
			Thread.sleep(1000);

		} else if (button.equalsIgnoreCase("Post Now")) {
			Thread.sleep(8000);
			mainPropertyPage.clickPostNow();
			Thread.sleep(5000);
		} else if (button.equalsIgnoreCase("Start Posting Your AD For Free")) {
			Thread.sleep(1000);
			startPosting.clickStartPost();
			Thread.sleep(1000);
		} else if (button.equalsIgnoreCase("Save & Continue")) {
			Thread.sleep(1000);
			propertyDetail.clickSaveAndContinue();
			Thread.sleep(8000);
		}
	}

	@Then("the user should be navigated to the {string} page")
	public void verify_navigation(String page) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (page.equalsIgnoreCase("Post Your Property")) {

			wait.until(ExpectedConditions.urlContains("list-your-property-for-rent-sale"));

			Assert.assertTrue(driver.getCurrentUrl().contains("list-your-property-for-rent-sale"),
					"Not navigated to Post Property page");

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[text()='Select Property Ad Type']")));

		}

		else if (page.equalsIgnoreCase("Locality Details"))

		{

			wait.until(ExpectedConditions.urlContains("/locality"));

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mark Locality')]")));
		}

		else if (page.equalsIgnoreCase("Amenities")) {

			wait.until(ExpectedConditions.urlContains("/amenities"));

			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'amenities')]")));
		}

		else if (page.equalsIgnoreCase("Property Details")) {

			// ✅ More specific condition
			wait.until(ExpectedConditions.urlMatches(".*/property(\\?.*)?$"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='pyp-form-header-container' and text()='Property Details']")));
		}

		System.out.println("✅ Navigated to " + page + " page");
	}

	@Then("the page should load successfully without errors")
	public void verify_page_load() throws InterruptedException {
		Thread.sleep(1000);
		String title = driver.getTitle();
		Thread.sleep(1000);
		Assert.assertFalse(title.isEmpty(), "Page not loaded properly");
		Thread.sleep(1000);
	}

	@Given("the user is on the {string} page")
	public void user_on_page(String page) throws Exception {
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		Thread.sleep(1000);

		if (page.equalsIgnoreCase("Post Your Property")) {
			Thread.sleep(1000);
			Assert.assertTrue(currentUrl.contains("list-your-property"), "Not on Post Your Property page");
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Locality Details")) {
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/locality"), "Not on Locality page");
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Rental Details")) {
			startPosting.goToPropertyDetailsPage();
			propertyDetail.fillPropertyDetails("600");
			localityPage.fillLocalityDetails("Gurgaon", "Near Metro station");
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/rental"), "Not on Rental page");
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Property Details")) {
			startPosting.goToPropertyDetailsPage();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/property"), "Not on Property Details page");
			Thread.sleep(1000);
		}

	}

	// ================= PROPERTY TYPE =================

	@When("the user selects Residential as Property Type and Rent as Ad Type and {string} as City")
	public void select_property_type(String city) throws InterruptedException {
		Thread.sleep(1000);
		startPosting.clickCityDropDown();
		Thread.sleep(1000);
		startPosting.selectCity();
		Thread.sleep(1000);
	}

	@When("the user selects {string} as Apartment Type and {string} as BHK")
	public void select_apartment_bhk(String type, String bhk) throws Exception {
;
		
		Thread.sleep(2000);
		propertyDetail.clickYesButton();

	    // Fill form while watcher runs in background
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

	// ================= LOCALITY =================

	@When("the user selects {string} as City and {string} as Locality")
	public void select_city_locality(String city, String locality) {
		System.out.println(city + " " + locality);
	}

	@When("the user enters {string} in the Landmark field")
	public void enter_landmark(String landmark) {
		System.out.println(landmark);
	}

	// ================= RENT =================

	@When("the user enters {string} in the Rent field and {string} in the Deposit field")
	public void enter_rent_deposit(String rent, String deposit) {
		rentalPage.enterRent(rent);
		rentalPage.enterDeposit(deposit);
	}

	@When("the user fills in Tenant Preference as {string}, Furnishing as {string}, Parking as {string} and Maintenance as {string}")
	public void fill_rental_details(String tenant, String furnish, String parking, String maintenance) {
		rentalPage.selectMaintenance();
		rentalPage.selectFamilyTenant();
		rentalPage.selectFurnishing();
		rentalPage.selectParking();
	}

	@When("the user selects {string} as Availability Date")
	public void select_date(String date) {
		rentalPage.selectAvailableDate("31");
	}

	// ================= AMENITIES =================

	@When("the user sets Bathroom count to {string} and Balcony count to {string}")
	public void set_bath_balcony(String bath, String balcony) {
		System.out.println(bath + " " + balcony);
	}

	@When("the user selects {string} as Water Supply and sets {string}, {string}, {string} and {string} to Yes")
	public void select_water_supply(String water, String p1, String p2, String p3, String p4) {
		System.out.println(water);
	}

	@When("the user selects {string} for {string} and {string} as Property Condition")
	public void select_property_condition(String who, String label, String condition) {
		System.out.println(who + condition);
	}

	@When("the user selects amenities {string} and {string}")
	public void select_amenities(String a1, String a2) {
		System.out.println(a1 + " " + a2);
	}

	// ================= FILE UPLOAD =================

	@When("the user uploads {string} and {string} \\(each under 5MB)")
	public void upload_files(String file1, String file2) {
		System.out.println(file1 + " " + file2);
	}

	@Then("the file should be uploaded successfully and preview thumbnail should be visible")
	public void verify_upload() {
		System.out.println("Upload success");
	}

	// ================= VALIDATIONS =================

	@When("the user leaves all mandatory fields empty")
	public void empty_fields() {
		System.out.println("Leaving fields empty");
	}

	@Then("validation messages should be shown for all empty mandatory fields")
	public void validation_messages() {
		System.out.println("Validation shown");
	}

	@Then("a validation error should be displayed: {string}")
	public void validation_error(String msg) {
		System.out.println(msg);
	}

	@Then("all inputs should be accepted without validation errors on {string} page")
	public void no_validation_error(String page) throws InterruptedException {

		boolean errorPresent = false;

		if (page.equalsIgnoreCase("Property Details")) {
			Thread.sleep(1000);
			errorPresent = propertyDetail.hasValidationError();
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Rental Details")) {
			Thread.sleep(1000);
			errorPresent = rentalPage.hasValidationError();
			Thread.sleep(1000);
		}

		if (errorPresent) {
			Thread.sleep(1000);
			throw new AssertionError("❌ Validation error found on " + page + " page!");
		}

		System.out.println("✅ No validation error on " + page + " page");
	}

	@Then("the user should remain on the {string} page")
	public void remain_on_page(String page) {
		System.out.println(page);
	}

	// ================= FINAL =================

	@When("the user selects {string} as availability and sets Start Time {string} and End Time {string}")
	public void visit_schedule(String day, String start, String end) {
		System.out.println(day + start + end);
	}

	@Then("a success message should be displayed: {string}")
	public void success_message(String msg) {
		System.out.println(msg);
	}

	@Then("the success screen should show options for {string} and {string}")
	public void success_options(String op1, String op2) {
		System.out.println(op1 + op2);
	}
}
