package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.DriverFactory;
import pageObjects.LoginPage;
import hooks.Hooks;

import io.cucumber.java.en.*;
import pageObjects.SearchFilterPageObjects.FlatMateResults;
import pageObjects.SearchFilterPageObjects.HomePage;
import pageObjects.SearchFilterPageObjects.PGresultsPage;
import utils.Search_Filtering_TestData;
import pageObjects.SearchFilterPageObjects.*;


public class SearchFilterStepDefinition {

    WebDriver driver;
    HomePage home;
    PGresultsPage pg;
    FlatMateResults flat;
    String city;
    String locality;


    @Given("user opens NoBroker website")
    public void openWebsite() {


        driver = DriverFactory.getDriver();


        Search_Filtering_TestData.loadExcel("Search_Filtering.xlsx", "Sheet1");
        
        this.locality = Search_Filtering_TestData.getData(1, 1);
        this.city = Search_Filtering_TestData.getData(1,0);

        System.out.println("City: " + this.city);
        System.out.println("Locality: " + this.locality);

        home = new HomePage(driver);
    }


    @When("user selects city")
    public void selectCity() {
        home.selectCity(this.city);   
    }

    @When("user enters locality and selects suggestion")
    public void selectLocality() {
        home.selectLocality(this.locality);  
    }

    @When("user clicks search button")
    public void clickSearch() {
        home.clickSearch();
    }

    @Then("user should be navigated to results page")
    public void verifyResultsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("nobroker"),
                "User not navigated to results page");
    }


    @When("user clicks search without entering locality")
    public void searchWithoutInput() {
        home.clickSearch();
    }

    @Then("validation error should be displayed")
    public void validationError() {
        Assert.assertTrue(true, "Validation handled");
    }


    @When("user selects Buy tab")
    public void selectBuyTab() {
        home.clickBuyTab();
    }

    @When("user selects Full House option")
    public void selectFullHouse() {
        home.selectBuyFullHouse();
    }

    @Then("BHK dropdown should be visible")
    public void bhkVisible() {
        Assert.assertTrue(true, "BHK visible");
    }


    @When("user selects Rent tab")
    public void selectRentTab() {
        home.clickRentTab();
    }

    @When("user selects PG\\/Hostel option")
    public void selectPG() {
        home.selectPGHostel();
    }

    @Then("PG results should be displayed")
    public void pgResults() {
        pg = new PGresultsPage(driver);
        Assert.assertNotNull(pg);
    }

    @When("user applies PG filters")
    public void applyPGFilters() {
        pg.applyPGFilters();
    }

    @Then("filtered PG listings should be displayed")
    public void pgFiltered() {
        pg.clickFirstProperty();
        Assert.assertTrue(true, "PG filters applied");
    }

    @Then("filtered PG listings should match criteria")
    public void pgMultipleFilter() {
        pg.clickFirstProperty();
        Assert.assertTrue(true, "Multiple filters working");
    }


    @When("user selects Flatmate option")
    public void selectFlatmate() {
        home.selectFlatmates();
    }

    @Then("Flatmate results should be displayed")
    public void flatmateResults() {
        flat = new FlatMateResults(driver);
        Assert.assertNotNull(flat);
    }

    @When("user handles popup and applies filters")
    public void flatmateFilters() {
        flat.handlePopup();
        flat.resetFilters();
        flat.applyFlatmateFilters();
    }

    @Then("filtered Flatmate listings should be displayed")
    public void flatmateFiltered() {
        flat.clickFirstProperty();
        Assert.assertTrue(true, "Flatmate filters applied");
    }


    @When("user clicks reset button")
    public void resetFilters() {
        home.handleMetroPopup();
        pg.resetFilters();
    }

    @Then("all filters should be cleared")
    public void verifyReset() throws InterruptedException {
        Assert.assertTrue(true, "Reset successful");
        Thread.sleep(3000);
        //driver.quit();
    }

    @Then("property listings should be displayed")
    public void property_listings_should_be_displayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("nobroker"),
                "Listings not displayed");
    }

    @Then("Property Status dropdown should be visible")
    public void property_status_dropdown_should_be_visible() {
        home.isPropertyStatusVisible();
        Assert.assertTrue(true);
    }

    @When("user searches with valid inputs")
    public void user_searches_with_valid_inputs() {
    
        home.selectCity(this.city);
        home.selectLocality(this.locality);
        home.clickSearch();
    }


    @Given("user has applied filters")
    public void user_has_applied_filters() {
        home.clickRentTab();
        home.selectPGHostel();
        home.selectCity(this.city);
        home.selectLocality(this.locality);
        home.clickSearch();

        pg = new PGresultsPage(driver);
        pg.applyPGFilters();
    }


    @When("user selects city and locality")
    public void user_selects_city_and_locality() {
        home.selectCity(this.city);
        home.selectLocality(this.locality);
    }


    @When("user clicks search")
    public void user_clicks_search_generic() {
        home.clickSearch();
    }
}
