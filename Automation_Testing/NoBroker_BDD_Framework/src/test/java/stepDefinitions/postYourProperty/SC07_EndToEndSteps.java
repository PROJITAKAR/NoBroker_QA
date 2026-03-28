package stepDefinitions.postYourProperty;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SC07_EndToEndSteps {
	
	@When("the user selects {string} as City and {string} as Locality")
	public void select_city_locality(String city, String locality) {
	    // TODO: implement
	}

	@When("the user enters {string} in the Landmark field")
	public void enter_landmark(String landmark) {
	    // TODO: implement
	}
	
	@When("the user sets Bathroom count to {string} and Balcony count to {string}")
	public void set_bath_balcony(String bath, String balcony) {
	    // TODO: implement
	}

	@When("the user selects {string} as Water Supply and sets {string}, {string}, {string} and {string} to Yes")
	public void select_water_supply(String water, String opt1, String opt2, String opt3, String opt4) {
	    // TODO: implement
	}

	@When("the user selects {string} for {string} and {string} as Property Condition")
	public void select_property_condition(String who, String label, String condition) {
	    // TODO: implement
	}

	@When("the user selects amenities {string} and {string}")
	public void select_amenities(String a1, String a2) {
	    // TODO: implement
	}

    @When("the user selects {string} as availability and sets Start Time {string} and End Time {string}")
    public void visit_schedule(String day, String start, String end) {}

    @Then("a success message should be displayed: {string}")
    public void success_message(String msg) {}

    @Then("the success screen should show options for {string} and {string}")
    public void success_options(String op1, String op2) {}
}