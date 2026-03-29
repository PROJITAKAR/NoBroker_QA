package stepDefinitions.postYourProperty;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.RentalDetailsPage;
import utils.DriverFactory;

public class SC03_RentalSteps {

    WebDriver driver = DriverFactory.getDriver();
    RentalDetailsPage rentalPage = new RentalDetailsPage(driver);

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
}
