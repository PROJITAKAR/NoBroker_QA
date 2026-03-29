package stepDefinitions.postYourProperty;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import utils.DriverFactory;

public class SC05_ValidationSteps {

	WebDriver driver = DriverFactory.getDriver();
	PropertyDetailsPage propertyPage = new PropertyDetailsPage(driver);

	@When("the user leaves all mandatory fields empty")
	public void empty_fields() throws InterruptedException, AWTException {
		propertyPage.clickYesButton();
	}

	@Then("validation messages should be shown for all empty mandatory fields")
	public void validation_messages() {

		boolean hasError = propertyPage.hasValidationError();

		Assert.assertTrue(hasError, "Validation errors are NOT displayed!");
	}

	
}