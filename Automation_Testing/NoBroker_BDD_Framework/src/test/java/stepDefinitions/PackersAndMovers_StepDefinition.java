package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.PackersAndMoversPage.InventoryPage;
import pageObjects.PackersAndMoversPage.LocationPage;
import pageObjects.PackersAndMoversPage.MenuPage;
import pageObjects.PackersAndMoversPage.SlotBookingPage;

import utils.DriverFactory;
import utils.ExcelUtil;

public class PackersAndMovers_StepDefinition {

    WebDriver driver = DriverFactory.getDriver();

    MenuPage menuPage = new MenuPage(driver);
    LocationPage locationPage = new LocationPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    SlotBookingPage slotBookingPage = new SlotBookingPage(driver);

    Map<String, String> testData;

    // ================= DATA LOADING =================

    @Given("user loads test data {string}")
    public void user_loads_test_data(String tcId) throws InterruptedException {
    	Thread.sleep(3000);
        testData = ExcelUtil.getTestData("PackersAndMovers", "Sheet1", tcId);
        
    }

    // ================= COMMON STEPS =================

    @And("user navigates to Packers and Movers Page")
    public void user_navigates_to_packers_and_movers_page() throws InterruptedException {
   // 	Thread.sleep(3000);
        menuPage.MenuClick();
        Thread.sleep(3000);
        menuPage.selectOption();
    }

    @And("user selects a city, pickup and drop location")
    public void user_selects_city_pickup_and_drop() throws InterruptedException {
    	Thread.sleep(3000);
        String pickup = testData.get("pickup");
        Thread.sleep(3000);
        String drop = testData.get("drop");
        Thread.sleep(3000);
        locationPage.pickupLoc(pickup);
        Thread.sleep(3000);
        locationPage.dropLoc(drop);
        Thread.sleep(3000);       
    }
    
    @When("user selects shifting type")
    public void user_selects_shifting_type() throws InterruptedException {
    	Thread.sleep(3000);
        locationPage.type();
    }

    @And("navigates to inventory Page")
    public void navigates_to_inventory_page() throws InterruptedException {
    	 Thread.sleep(3000);
         locationPage.checkPrices();
         Thread.sleep(3000);
         
    }

    // ================= SCENARIO 1 =================

    @Then("user searches for item")
    public void user_searches_for_item() throws InterruptedException {

        String item = testData.get("searchItem");
        Thread.sleep(3000);
        inventoryPage.searchItem();
        Thread.sleep(3000);
        inventoryPage.dataEntry(item);
    }

    @And("no relevant results should be displayed")
    public void no_relevant_results_should_be_displayed() throws InterruptedException {
        String actualMessage = inventoryPage.getNoItemMessage();
        Thread.sleep(3000);
        Assert.assertEquals(actualMessage, "No items found");
    }

    // ================= SCENARIO 2 =================

    @When("user selects category and adds item")
    public void user_selects_category_and_adds_item() throws InterruptedException {
    	Thread.sleep(3000);
    	String category = testData.get("category");
    	Thread.sleep(3000);
    	String type = testData.get("type");
    	Thread.sleep(3000);
    	String item = testData.get("item");
    	Thread.sleep(3000);
    	
        inventoryPage.selectCategory(category);
        Thread.sleep(3000);
        inventoryPage.selectType(type);
        Thread.sleep(3000);
        inventoryPage.addItem(item);
        Thread.sleep(3000);

        inventoryPage.continueClick();
    }
    
    @And("selects a valid pickup date")
    public void selects_valid_pickup_date() throws InterruptedException {
    	Thread.sleep(3000);
        slotBookingPage.selectDate();
    }

    @And("selects a valid slot and confirms")
    public void selects_valid_slot_and_confirm() throws InterruptedException {
    	Thread.sleep(3000);
        slotBookingPage.selectValidTime();
        Thread.sleep(3000);
        slotBookingPage.confirm();
    }

    // ================= SCENARIO 3 =================

    @When("user updates the added item and continues")
    public void user_updates_item_and_continues() throws InterruptedException {
    	
    	Thread.sleep(3000);
    	String category = testData.get("category");
    	Thread.sleep(3000);
    	String type = testData.get("type");
    	Thread.sleep(3000);
    	String item = testData.get("item");
    	Thread.sleep(3000);
    	
        inventoryPage.selectCategory(category);
        Thread.sleep(3000);
        inventoryPage.selectType(type);
        Thread.sleep(3000);
     //   inventoryPage.addItem(item);
       
    //	Thread.sleep(3000);
        inventoryPage.increaseItem(item);
        
        Thread.sleep(3000);
        inventoryPage.continueClick();
    }

    // ================= COMMON VALIDATION =================

    @Then("Order summary page should open")
    public void order_summary_page_should_open() throws InterruptedException {
    	Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertTrue(
            url.contains("summary") || url.contains("order"),
            "Order Summary page not opened"
        );
    }
}