package stepDefinitions.postYourProperty;

import java.awt.AWTException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.PostYourProperty.PropertyDetailsPage;
import utils.DriverFactory;
import utils.ExcelUtil;

public class SC02_PropertyDetailsSteps {

	WebDriver driver = DriverFactory.getDriver();
	PropertyDetailsPage propertyDetail = new PropertyDetailsPage(driver);
	Map<String, String> data;

	@Given("the user loads property detail test data {string} from sheet {string}")
	public void the_user_loads_test_data_from_sheet(String tcId, String sheetName) {

		data = ExcelUtil.getTestData("PostYourProperty", sheetName, tcId);
	}

	@When("the user selects Apartment Type and BHK from test data")
	public void the_user_selects_apartment_type_and_bhk_from_test_data() throws InterruptedException, AWTException {
		propertyDetail.clickYesButton();

		propertyDetail.selectApartmentType();

		propertyDetail.selectBHK(data.get("bhk"));
	}

	@When("the user selects Floor and Property Age from test data")
	public void the_user_selects_floor_and_property_age_from_test_data() throws InterruptedException {
		propertyDetail.selectTotalFloor(data.get("floor"));

		propertyDetail.selectPropertyAge(data.get("propertyAge"));
	}

	@When("the user selects Facing and enters Built-up Area from test data")
	public void the_user_selects_facing_and_enters_built_up_area_from_test_data() throws InterruptedException {
		propertyDetail.selectFacing(data.get("facing"));

		propertyDetail.enterBuiltUpArea(data.get("builtUpArea"));
	}
}