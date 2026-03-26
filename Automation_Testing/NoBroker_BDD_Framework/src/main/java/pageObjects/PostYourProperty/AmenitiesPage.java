package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmenitiesPage {

    WebDriver driver;

    // Constructor
    public AmenitiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Bathroom & Balcony
    @FindBy(xpath = "//div[label[contains(text(),'Bathroom')]]//button[2]")
    WebElement bathroomPlus;

    @FindBy(xpath = "//div[label[contains(text(),'Balcony')]]//button[2]")
    WebElement balconyPlus;

    // Water Supply
    @FindBy(xpath = "//div[contains(text(),'Water Supply')]/following::div[text()='Select']")
    WebElement waterSupplyDropdown;

    @FindBy(xpath = "//div[contains(text(),'Borewell')]")
    WebElement waterSupplyOption;

    // Toggles
    @FindBy(id = "petAllowedYes")
    WebElement petAllowedYes;

    @FindBy(id = "gymYes")
    WebElement gymYes;

    @FindBy(id = "nonVegAllowedYes")
    WebElement nonVegYes;

    @FindBy(id = "gatedSecurityYes")
    WebElement gatedSecurityYes;

    // Who will show property
    @FindBy(xpath = "//div[contains(text(),'Who will show the property')]/following::div[text()='Select']")
    WebElement showPropertyDropdown;

    @FindBy(xpath = "//div[contains(text(),'Neighbours')]")
    WebElement showPropertyOption;

    // Property Condition
    @FindBy(xpath = "//div[contains(text(),'Current Property Condition')]/following::div[text()='Select']")
    WebElement propertyConditionDropdown;

    @FindBy(xpath = "//div[contains(text(),'New Property')]")
    WebElement propertyConditionOption;

    // Secondary Number
    @FindBy(xpath = "//input[contains(@placeholder,'Secondary Number')]")
    WebElement secondaryNumberInput;

    // More properties
    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    WebElement morePropertiesYes;

    // Directions
    @FindBy(xpath = "//textarea[contains(@placeholder,'Take the road')]")
    WebElement directionsInput;

    // ================= AMENITIES CHECKBOX =================

    @FindBy(xpath = "//label[contains(text(),'Lift')]")
    WebElement lift;

    @FindBy(xpath = "//label[contains(text(),'Swimming Pool')]")
    WebElement swimmingPool;

    @FindBy(xpath = "//label[contains(text(),'Power Backup')]")
    WebElement powerBackup;

    @FindBy(xpath = "//label[contains(text(),'Park')]")
    WebElement park;

    // ================= BUTTONS =================

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "back")
    WebElement backButton;

    // ================= ACTION METHODS =================

    public void increaseBathroom(int count) {
        for (int i = 0; i < count; i++) {
            bathroomPlus.click();
        }
    }

    public void increaseBalcony(int count) {
        for (int i = 0; i < count; i++) {
            balconyPlus.click();
        }
    }

    public void selectWaterSupply() {
        waterSupplyDropdown.click();
        waterSupplyOption.click();
    }

    public void selectPetAllowed() {
        petAllowedYes.click();
    }

    public void selectGym() {
        gymYes.click();
    }

    public void selectNonVeg() {
        nonVegYes.click();
    }

    public void selectGatedSecurity() {
        gatedSecurityYes.click();
    }

    public void selectWhoWillShowProperty() {
        showPropertyDropdown.click();
        showPropertyOption.click();
    }

    public void selectPropertyCondition() {
        propertyConditionDropdown.click();
        propertyConditionOption.click();
    }

    public void enterSecondaryNumber(String number) {
        secondaryNumberInput.clear();
        secondaryNumberInput.sendKeys(number);
    }

    public void selectMorePropertiesYes() {
        morePropertiesYes.click();
    }

    public void enterDirections(String text) {
        directionsInput.clear();
        directionsInput.sendKeys(text);
    }

    // Amenities
    public void selectAmenities() {
        lift.click();
        swimmingPool.click();
        powerBackup.click();
        park.click();
    }

    public void clickSaveAndContinue() {
        saveAndContinueButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
}