package stepDefinitions.postYourProperty;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.RentalDetailsPage;
import utils.DriverFactory;
import utils.ExcelUtil;

public class SC03_RentalSteps {

    WebDriver driver = DriverFactory.getDriver();
    RentalDetailsPage rentalPage = new RentalDetailsPage(driver);
    Map<String, String> data;
    
    @Given("the user loads rental test data {string} from sheet {string}")
    public void the_user_loads_rental_test_data_from_sheet(String tcId, String sheetName) {
    	data = ExcelUtil.getTestData("PostYourProperty", sheetName, tcId);
    }
    @When("the user enters Rent and Deposit from test data")
    public void the_user_enters_rent_and_deposit_from_test_data() throws InterruptedException {
    	rentalPage.enterRent(data.get("rent"));
        rentalPage.enterDeposit(data.get("deposit"));
    }

    @When("the user fills in Tenant Preference as {string}, Furnishing as {string}, Parking as {string} and Maintenance as {string}")
    public void fill_rental_details(String tenant, String furnish, String parking, String maintenance) throws InterruptedException {
        rentalPage.selectMaintenance();
        rentalPage.selectFamilyTenant();
        rentalPage.selectFurnishing();
        rentalPage.selectParking();
    }

    @When("the user selects {string} as Availability Date")
    public void select_date(String date) throws InterruptedException {
        rentalPage.selectAvailableDate("31");
    }
}
