package pageObjects;

import org.openqa.selenium.WebDriver;

public class PackersAndMoversPage {

    WebDriver driver;

    public PackersAndMoversPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigation
    public void navigateToPackersPage() {
        driver.get("https://www.nobroker.in/packers-and-movers");//need to change
    }

    // Validation
    public String getPageTitle() {
        return driver.getTitle();
    }
}