package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviewListingPage {

    WebDriver driver;

    // Constructor
    public PreviewListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Property Title
    @FindBy(xpath = "//h1[contains(text(),'BHK')]")
    WebElement propertyTitle;

    // Rent
    @FindBy(xpath = "//div[contains(text(),'Rent')]/preceding-sibling::div")
    WebElement rentValue;

    // Deposit
    @FindBy(xpath = "//div[contains(text(),'Deposit')]/preceding-sibling::div")
    WebElement depositValue;

    // Area
    @FindBy(xpath = "//div[contains(text(),'Sq.Ft')]/preceding-sibling::div")
    WebElement areaValue;

    // Edit Property Button
    @FindBy(xpath = "//button[contains(text(),'Edit Property')]")
    WebElement editPropertyButton;

    // Shortlist Button
    @FindBy(xpath = "//button[contains(text(),'Shortlist')]")
    WebElement shortlistButton;

    // Add Photos Button
    @FindBy(xpath = "//button[contains(text(),'Add Photos')]")
    WebElement addPhotosButton;

    // Preferred Tenant
    @FindBy(xpath = "//div[contains(text(),'Preferred Tenant')]/preceding-sibling::div")
    WebElement preferredTenant;

    // Parking
    @FindBy(xpath = "//div[contains(text(),'Parking')]/preceding-sibling::div")
    WebElement parking;

    // ================= ACTION METHODS =================

    public String getPropertyTitle() {
        return propertyTitle.getText();
    }

    public String getRent() {
        return rentValue.getText();
    }

    public String getDeposit() {
        return depositValue.getText();
    }

    public String getArea() {
        return areaValue.getText();
    }

    public String getPreferredTenant() {
        return preferredTenant.getText();
    }

    public String getParking() {
        return parking.getText();
    }

    public void clickEditProperty() {
        editPropertyButton.click();
    }

    public void clickShortlist() {
        shortlistButton.click();
    }

    public void clickAddPhotos() {
        addPhotosButton.click();
    }
}