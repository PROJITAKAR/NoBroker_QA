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
    @FindBy(id = "inc-btn-bathroom-counter-input-filed")
    WebElement bathroomPlus;

    @FindBy(id = "inc-btn-balconie-counter-input-field")
    WebElement balconyPlus;

    // Water Supply
    @FindBy(id = "amenitiesPypForm-waterSupply-nbInput")
    WebElement waterSupplyDropdown;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-waterSupply-nbInput-container']//div[text()='Borewell']")
    WebElement waterSupplyOption;

    // Toggles
    @FindBy(xpath = "//div[@id='pet-toogle-input-field']//input[@id='positive-btn']")
    WebElement petAllowedYes;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-gym-nbInput-container']//input[@id='positive-btn']")
    WebElement gymYes;

    @FindBy(xpath = "//div[@id='non-veg-toggle-input-field']//input[@id='positive-btn']")
    WebElement nonVegYes;

    @FindBy(xpath = "//div[@id='gated-security-toggle-input-field']//input[@id='positive-btn']")
    WebElement gatedSecurityYes;

    // Who will show property
    @FindBy(xpath = "//div[@id='aea__HOUSE_KEY_WITH-aea__HOUSE_KEY_WITH-nbInput']")
    WebElement showPropertyDropdown;

    @FindBy(xpath = "//div[@id='aea__HOUSE_KEY_WITH-aea__HOUSE_KEY_WITH-nbInput']/div/div//div[text()='Neighbours']")
    WebElement showPropertyOption;

    // Property Condition
    @FindBy(xpath = "//div[@id='CURRENT_SITUATION-CURRENT_SITUATION-nbInput']")
    WebElement propertyConditionDropdown;

    @FindBy(xpath = "//div[@id='CURRENT_SITUATION-CURRENT_SITUATION-nbInput']/div/div//div[text()='New Property']")
    WebElement propertyConditionOption;

//    // Secondary Number
//    @FindBy(xpath = "//input[contains(@placeholder,'Secondary Number')]")
//    WebElement secondaryNumberInput;
//
//    // More properties
//    @FindBy(xpath = "//label[contains(text(),'Yes')]")
//    WebElement morePropertiesYes;

    // Directions
    @FindBy(xpath = "//div[@controlid='directions']")
    WebElement directionsInput;

    // ================= AMENITIES CHECKBOX =================

    @FindBy(xpath = "//input[@id='LIFT']")
    WebElement lift;

    @FindBy(xpath = "//input[@id='POOL']")
    WebElement swimmingPool;

//    @FindBy(xpath = "//label[contains(text(),'Power Backup')]")
//    WebElement powerBackup;
//
//    @FindBy(xpath = "//label[contains(text(),'Park')]")
//    WebElement park;

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

//    public void enterSecondaryNumber(String number) {
//        secondaryNumberInput.clear();
//        secondaryNumberInput.sendKeys(number);
//    }
//
//    public void selectMorePropertiesYes() {
//        morePropertiesYes.click();
//    }

    public void enterDirections(String text) {
        directionsInput.clear();
        directionsInput.sendKeys(text);
    }

    // Amenities
    public void selectAmenities() {
        lift.click();
        swimmingPool.click();
//        powerBackup.click();
//        park.click();
    }

    public void clickSaveAndContinue() {
        saveAndContinueButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
    
    public void fillAmenitiesDetails() throws InterruptedException {

        // Bathroom & Balcony
        increaseBathroom(1);
        Thread.sleep(1000);

        increaseBalcony(1);
        Thread.sleep(1000);

        // Water Supply
        selectWaterSupply();
        Thread.sleep(2000);

        // Toggles
        selectPetAllowed();
        Thread.sleep(1000);

        selectGym();
        Thread.sleep(1000);

        selectNonVeg();
        Thread.sleep(1000);

        selectGatedSecurity();
        Thread.sleep(1000);

        // Who will show property
        selectWhoWillShowProperty();
        Thread.sleep(2000);

        // Property condition
        selectPropertyCondition();
        Thread.sleep(2000);

        // Directions
        enterDirections("Near main road");
        Thread.sleep(2000);

        // Amenities
        selectAmenities();
        Thread.sleep(2000);

        // Save
        clickSaveAndContinue();
        Thread.sleep(5000);

        System.out.println("✅ Amenities Details filled and submitted");
    }
}