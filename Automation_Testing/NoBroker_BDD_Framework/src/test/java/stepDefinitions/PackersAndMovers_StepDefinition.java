package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

import pageObjects.PackersAndMoversPage.MenuPage;
import pageObjects.PackersAndMoversPage.LocationPage;
import pageObjects.PackersAndMoversPage.InventoryPage;
import utils.DriverFactory;

public class PackersAndMovers_StepDefinition {

    WebDriver driver = DriverFactory.getDriver();

    MenuPage menuPage = new MenuPage(driver);
    LocationPage locationPage = new LocationPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    // Step 1
    @Given("user navigates to Packers and Movers Page")
    public void user_navigates_to_packers_and_movers_page() {
        //driver.get("https://www.nobroker.in/");
        menuPage.MenuClick();
        menuPage.selectOption();
    }

    // Step 2
    @And("user selects a city, pickup and drop location")
    public void user_selects_city_pickup_and_drop() throws InterruptedException {
        locationPage.pickupLoc("Koramangala");
        Thread.sleep(2000); 

        locationPage.dropLoc("Cox Town");
        Thread.sleep(2000);
    }

    // Step 3
    @When("user selects {string} option")
    public void user_selects_shifting_type() {
        locationPage.type(); 
    }

    // Step 4
    @And("navigates to inventory Page")
    public void navigates_to_inventory_page() {
        locationPage.checkPrices();
    }

    // Step 5
    @Then("user searches for item {string}")
    public void user_searches_for_item(String item) throws InterruptedException {
        inventoryPage.searchItem();
        inventoryPage.dataEntry(item);
        Thread.sleep(2000);
    }

    // Step 6
    @And("no relevant results should be displayed")
    public void no_relevant_results_should_be_displayed() {
        String actualMessage = inventoryPage.getNoItemMessage();
        Assert.assertEquals(actualMessage, "No items found");
    }
}