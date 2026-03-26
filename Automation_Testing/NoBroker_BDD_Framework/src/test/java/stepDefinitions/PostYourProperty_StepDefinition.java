package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class PostYourProperty_StepDefinition {
	
	WebDriver driver = DriverFactory.getDriver();


    @Given("the user is on the NoBroker Homepage")
    public void user_on_homepage() {}

    @When("the user clicks {string} in the header")
    public void click_header(String option) {}

    @When("the user clicks {string}")
    public void click_button(String button) {}

    @Given("the user is on the {string} page")
    public void user_on_page(String page) {}

    @Then("the user should be redirected to the {string} page")
    public void redirected_to_page(String page) {}

    @Then("the page should load successfully without errors")
    public void page_load_success() {}

    @Then("the user should be navigated to the {string} page")
    public void navigated_to_page(String page) {}

    @Then("the user should remain on the {string} page")
    public void remain_on_page(String page) {}

    // ---------- SELECTION ----------
    @Given("the user selects property type {string} and ad type {string}")
    public void select_property_and_ad(String type, String adType) {}

    @Given("the user selects city {string}")
    public void select_city(String city) {}

    @When("the user selects {string} as {string}")
    public void select_generic(String value, String field) {}

    // ---------- PROPERTY FLOW ----------
    @When("the user completes Property Details and clicks {string}")
    public void complete_property_details(String btn) {}

    @When("the user completes Locality Details and clicks {string}")
    public void complete_locality_details(String btn) {}

    @When("the user completes Rental Details and clicks {string}")
    public void complete_rental_details(String btn) {}

    @When("the user completes Amenities and clicks {string}")
    public void complete_amenities(String btn) {}

    // ---------- INPUTS ----------
    @When("the user enters {string} as {string}")
    public void enter_value(String value, String field) {}

    // ---------- LOCATION ----------
    @When("the user selects {string} from the City dropdown")
    public void select_city_dropdown(String city) {}

    @When("the user selects {string} from the Locality dropdown")
    public void select_locality_dropdown(String locality) {}

    // ---------- VALIDATION ----------
    @Then("validation messages should be displayed for all empty mandatory fields")
    public void validation_messages() {}

    @Then("a validation error should be displayed: {string}")
    public void validation_error(String msg) {}

    @Then("a validation error should be displayed for the city-locality mismatch")
    public void validation_mismatch() {}

    @Then("all inputs should be accepted without validation errors")
    public void inputs_accepted() {}

    // ---------- UPLOAD ----------
    @When("the user uploads {string}")
    public void upload_file(String file) {}

    @Then("both photos should be uploaded successfully")
    public void photos_uploaded() {}

    @Then("preview thumbnails should be visible")
    public void thumbnails_visible() {}

    // ---------- SCHEDULE ----------
    @When("the user sets availability {string}")
    public void set_availability(String avail) {}

    @When("the user sets time {string} to {string}")
    public void set_time(String start, String end) {}

    // ---------- FINAL ----------
    @When("the user clicks {string} button")
    public void click_button_generic(String btn) {}

    @Then("all inputs should be accepted and the user should reach the final submission step")
    public void final_step() {}

    @Then("a success message should be displayed: {string}")
    public void success_message(String msg) {}

    @Then("the success screen should show options for {string} and {string}")
    public void success_options(String opt1, String opt2) {}
    
 // ---------- PROPERTY DETAILS ----------

    @When("the user selects {string} as Apartment Type")
    public void select_apartment_type(String value) {
        // TODO
    }

    @When("the user selects {string} as BHK and {string} as Floor")
    public void select_bhk_and_floor(String bhk, String floor) {
        // TODO
    }

    @When("the user selects {string} as Property Age")
    public void select_property_age(String value) {
        // TODO
    }

    @When("the user selects {string} as Facing")
    public void select_facing(String value) {
        // TODO
    }

    @When("the user enters {string} as Built-up Area")
    public void enter_builtup_area(String value) {
        // TODO
    }


    // ---------- RENTAL DETAILS ----------

    @When("the user enters {string} as Rent and {string} as Deposit")
    public void enter_rent_and_deposit(String rent, String deposit) {
        // TODO
    }

}
