package stepDefinitions.postYourProperty;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.AmenitiesPage;
import pageObjects.PostYourProperty.LocalityDetailsPage;
import pageObjects.PostYourProperty.NavigationToPostYourProperty;
import pageObjects.PostYourProperty.PostYourPropertyMainPage;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import pageObjects.PostYourProperty.RentalDetailsPage;
import pageObjects.PostYourProperty.StartPostingYourAD;
import pageObjects.PostYourProperty.UploadMediaPage;
import utils.DriverFactory;

public class CommonSteps {

	WebDriver driver = DriverFactory.getDriver();
	RentalDetailsPage rentalPage = new RentalDetailsPage(driver);

	NavigationToPostYourProperty navigate = new NavigationToPostYourProperty(driver);
	PostYourPropertyMainPage mainPropertyPage = new PostYourPropertyMainPage(driver);
	StartPostingYourAD startPosting = new StartPostingYourAD(driver);
	PropertyDetailsPage propertyDetail = new PropertyDetailsPage(driver);
	LocalityDetailsPage localityPage = new LocalityDetailsPage(driver);
	AmenitiesPage amenitiesPage = new AmenitiesPage(driver);
	UploadMediaPage gallery = new UploadMediaPage(driver);

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
			Assert.assertTrue(driver.getCurrentUrl().contains("list-your-property-for-rent-sale"));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Select Property Ad Type']")));
		}

		else if (page.equalsIgnoreCase("Locality Details")) {
			wait.until(ExpectedConditions.urlContains("/locality"));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mark Locality')]")));
		}

		else if (page.equalsIgnoreCase("Amenities")) {
			wait.until(ExpectedConditions.urlContains("/amenities"));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'amenities')]")));
		}

		else if (page.equalsIgnoreCase("Schedule")) {
			wait.until(ExpectedConditions.urlContains("/scheduler"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Availability']")));
		}

		else if (page.equalsIgnoreCase("Property Details")) {
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
			Assert.assertTrue(currentUrl.contains("list-your-property"));
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Locality Details")) {
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/locality"));
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Rental Details")) {
			startPosting.goToPropertyDetailsPage();
			propertyDetail.fillPropertyDetails("600");
			localityPage.fillLocalityDetails("Gurgaon", "Near Metro station");
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/rental"));
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Photo Upload")) {
			startPosting.goToPropertyDetailsPage();
			propertyDetail.fillPropertyDetails("600");
			localityPage.fillLocalityDetails("Gurgaon", "Near Metro station");
			rentalPage.fillRentalDetails("2000", "3000");
			amenitiesPage.fillAmenitiesDetails();
			gallery.goToGallery();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/gallery"));
			Thread.sleep(1000);
		} else if (page.equalsIgnoreCase("Property Details")) {
			startPosting.goToPropertyDetailsPage();
			Thread.sleep(1000);
			Assert.assertTrue(driver.getCurrentUrl().contains("/property"));
			Thread.sleep(1000);
		}
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (page.equalsIgnoreCase("Property Details")) {

			wait.until(ExpectedConditions.urlContains("/property"));

			Assert.assertTrue(driver.getCurrentUrl().contains("/property"),
					"User navigated away from Property Details page!");

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='pyp-form-header-container' and text()='Property Details']")));

			System.out.println("✅ User remains on Property Details page");
		} else if (page.equalsIgnoreCase("Rental Details")) {

			wait.until(ExpectedConditions.urlContains("/rental"));

			Assert.assertTrue(driver.getCurrentUrl().contains("/rental"),
					"User navigated away from Rental Details page!");

			// Optional (add if you have stable element)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rent"))); // rent field present

			System.out.println("✅ User remains on Rental Details page");
		}
	}

}