package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import managers.PageObjectManager;
import pageObjects.PostYourProperty.RentalDetailsPage;
import utils.DriverFactory;

public class SC06_NegativeSteps {
	
	WebDriver driver = DriverFactory.getDriver();
	private PageObjectManager pm = new PageObjectManager(driver);
	private RentalDetailsPage rentalPage = pm.rentalDetailsPage();

    @Then("a validation error should be displayed: {string}")
    public void validation_error(String msg) {

        String actualMessage = rentalPage.getDepositValidationMessage();

        Assert.assertTrue(
            actualMessage.trim().equalsIgnoreCase(msg),
            "❌ Expected: " + msg + " but got: " + actualMessage
        );
    }
}