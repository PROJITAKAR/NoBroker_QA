package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.PackersAndMoversPage;
import utils.DriverFactory;

public class PackersAndMovers_StepDefinition {

    WebDriver driver = DriverFactory.getDriver();
    PackersAndMoversPage page = new PackersAndMoversPage(driver);

    @Given("user is on Packers and Movers page")
    public void user_on_packers_page() {
        page.navigateToPackersPage();
    }

    @Then("page should load successfully")
    public void verify_page() {
        String title = page.getPageTitle();
        Assert.assertTrue(title.contains("Packers"));
    }
}