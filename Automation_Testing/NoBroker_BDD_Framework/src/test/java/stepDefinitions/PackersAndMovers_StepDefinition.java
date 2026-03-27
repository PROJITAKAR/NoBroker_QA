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
    public void user_loads_test_data(String tcId) {
        testData = ExcelUtil.getTestData("PackersAndMovers", "Sheet1", tcId);
    }

    // ================= COMMON STEPS =================

    @And("user navigates to Packers and Movers Page")
    public void user_navigates_to_packers_and_movers_page() {
        menuPage.MenuClick();
        menuPage.selectOption();
    }

    @And("user selects a city, pickup and drop location")
    public void user_selects_city_pickup_and_drop() {

        String pickup = testData.get("pickup");
        String drop = testData.get("drop");

        locationPage.pickupLoc(pickup);
        locationPage.dropLoc(drop);

        locationPage.type();
        locationPage.checkPrices();
    }
    @When("user selects shifting type")
    public void user_selects_shifting_type() {
        locationPage.type();
    }

    @And("navigates to inventory Page")
    public void navigates_to_inventory_page() {
        // already handled in checkPrices()
    }

    // ================= SCENARIO 1 =================

    @Then("user searches for item")
    public void user_searches_for_item() {

        String item = testData.get("searchItem");

        inventoryPage.searchItem();
        inventoryPage.dataEntry(item);
    }

    @And("no relevant results should be displayed")
    public void no_relevant_results_should_be_displayed() {
        String actualMessage = inventoryPage.getNoItemMessage();
        Assert.assertEquals(actualMessage, "No items found");
    }

    // ================= SCENARIO 2 =================

    @When("user selects category {string}, type {string} and adds item {string}")
    public void user_selects_category_and_adds_item(String category, String type, String item) {

        inventoryPage.selectCategory(category);
        inventoryPage.selectType(type);
        inventoryPage.addItem(item);

        inventoryPage.continueClick();
    }
    
    @And("selects a valid pickup date")
    public void selects_valid_pickup_date() {
        slotBookingPage.selectDate();
    }

    @And("selects a valid slot and confirms")
    public void selects_valid_slot_and_confirm() {
        slotBookingPage.selectValidTime();
        slotBookingPage.confirm();
    }

    // ================= SCENARIO 3 =================

    @When("user updates the added item and continues")
    public void user_updates_item_and_continues() {

        inventoryPage.increase();
        inventoryPage.decrease();

        inventoryPage.continueClick();
    }

    // ================= COMMON VALIDATION =================

    @Then("Order summary page should open")
    public void order_summary_page_should_open() {

        String url = driver.getCurrentUrl();

        Assert.assertTrue(
            url.contains("summary") || url.contains("order"),
            "Order Summary page not opened"
        );
    }
}