package stepDefinitions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EPC.AddressPage;
import pageObjects.EPC.DateSlotPage;
import pageObjects.EPC.HomePage;
import pageObjects.EPC.HomeServicesPage;
import pageObjects.EPC.OrderSummaryPage;
import pageObjects.EPC.SubServicesPage;
import utils.DriverFactory;
import utils.ExcelUtil;
import java.util.Map;



public class EPC_StepDefinition {
	
	Map<String, String> testData;
	WebDriver driver;
    HomePage homePage;
    HomeServicesPage homeServicesPage;
    SubServicesPage subServicesPage;
    AddressPage addressPage;
    DateSlotPage dateSlotPage;
    OrderSummaryPage orderSummaryPage;

    @Before
    public void initPages() {
        driver           = DriverFactory.getDriver();
        homePage         = new HomePage(driver);
        homeServicesPage = new HomeServicesPage(driver);
        subServicesPage  = new SubServicesPage(driver);
        addressPage      = new AddressPage(driver);
        dateSlotPage     = new DateSlotPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
    }
	        
	
	   
    @Given("User loads EPC test data {string}")
    public void user_loads_epc_test_data(String tcId) {
        testData = ExcelUtil.getTestData("EPC_TestData", "EPC_TestData", tcId);
    }
	    
	@Given("User is on the NoBroker homepage")
	public void user_is_on_the_no_broker_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl().contains("nobroker.in"));
		
	}

	@When("User clicks on Painting and Cleaning option")
	public void user_clicks_on_painting_and_cleaning_option() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		homePage.clickPaintingAndCleaning();
		for (String windowHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(windowHandle);
	    }
		
		Thread.sleep(2000);
		homeServicesPage.selectCity();;
	    
	}

	@Then("Home Services landing page should be displayed with all service tiles")
	public void home_services_landing_page_should_be_displayed_with_all_service_tiles() throws InterruptedException {
		
	    Assert.assertTrue(homeServicesPage.areServiceTilesVisible());
	}

	@When("User clicks on Electrician tile")
	public void user_clicks_on_electrician_tile() {
	    // Write code here that turns the phrase above into concrete actions
		homeServicesPage.clickEPC();
		homeServicesPage.clickElectrician();
	   
	}

	@Then("Electrician sub-services page should be displayed with name and price")
	public void electrician_sub_services_page_should_be_displayed_with_name_and_price() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl().contains("electrician"));
	    
	}

	@When("User does not select any service")
	public void user_does_not_select_any_service() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Proceed button should not be visible")
	public void proceed_button_should_not_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertFalse(subServicesPage.isProceedButtonDisplayed());
	    
	}

	@When("User adds a service")
	public void user_adds_a_service() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		subServicesPage.addService();
		Thread.sleep(5000);
	    
	}

	@Then("Order summary should be visible with Proceed button active")
	public void order_summary_should_be_visible_with_proceed_button_active() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(subServicesPage.isProceedButtonDisplayed());
	    
	}

	@When("User clicks Proceed")
	public void user_clicks_proceed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		subServicesPage.clickProceed();
		Thread.sleep(5000);
	    
	}

	@Then("Address page should be displayed with location search bar")
	public void address_page_should_be_displayed_with_location_search_bar() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.getCurrentUrl().contains("slots")) {
		dateSlotPage.clickChange();
		Thread.sleep(2000);
		dateSlotPage.clickAddAddress();
		Thread.sleep(5000);
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("address"));
		
	}

	@When("User searches and selects location")
	public void user_searches_and_selects_location() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String location = testData.get("Location");
	    System.out.println("Location: " + location);
	    addressPage.searchAndSelectLocation(location);
	    addressPage.ClickConfirmLoc();
	    Thread.sleep(2000);
		
	}

	@When("User enters flat no and landmark")
	public void user_enters_flat_no_and_landmark() throws InterruptedException {
		String flatNo   = testData.get("FlatNo");
	    String landmark = testData.get("Landmark");
	    String saveAs = testData.get("SaveAs");
	    System.out.println("FlatNo: " + flatNo + " | Landmark: " + landmark);
	    addressPage.enterFlatNo(flatNo);
	    addressPage.enterLandmark(landmark);
	    if(saveAs.equals("Home")) {
	    	addressPage.setSaveAsHome();
	    }
	    else addressPage.setSaveAsWork();
	    
	    Thread.sleep(5000);
	}

	@When("User clicks Proceed on address page")
	public void user_clicks_proceed_on_address_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		addressPage.clickProceed();
		Thread.sleep(5000);
	    
	}

	@Then("Date and slot selection page should be displayed")
	public void date_and_slot_selection_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl().contains("slots"));
	}

	@When("User selects date and slot")
	public void user_selects_date_and_slot() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    dateSlotPage.selectDate();
	    Thread.sleep(3000);
	    dateSlotPage.selectFirstSlot();
	    Thread.sleep(3000);
	}

	@When("User clicks Proceed on date slot page")
	public void user_clicks_proceed_on_date_slot_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		dateSlotPage.clickProceed();
		Thread.sleep(5000);
	    
	}

	@When("User clicks Pay Now on order summary")
	public void user_clicks_pay_now_on_order_summary() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		orderSummaryPage.clickPayNow();
		driver.findElement(By.xpath("//button[text()='Skip']")).click();
		Thread.sleep(5000);
		
	    
	}

	@Then("Payment portal page should be displayed")
	public void payment_portal_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
	}
}
