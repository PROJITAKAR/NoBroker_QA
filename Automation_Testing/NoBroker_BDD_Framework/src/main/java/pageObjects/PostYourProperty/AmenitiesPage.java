package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmenitiesPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public AmenitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	@FindBy(xpath = "//div[@id='amenitiesPypForm-aea__PET-nbInput-container']//input[@value='true']")
	WebElement petAllowedYes;

	@FindBy(xpath = "//div[@id='amenitiesPypForm-gym-nbInput-container']//input[@value='true']")
	WebElement gymYes;

	@FindBy(xpath = "//div[@id='amenitiesPypForm-aea__NON_VEG_ALLOWED-nbInput-container']//input[@value='true']")
	WebElement nonVegYes;

	@FindBy(xpath = "//div[@id='amenitiesPypForm-aea__GATED_SECURITY-nbInput-container']//input[@value='true']")
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
	@FindBy(xpath = "//textarea[contains(@placeholder,'Eg. Take the road')]")
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

	// ================= ACTION METHODS =================

	public void increaseBathroom(int count) {
		for (int i = 0; i < count; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(bathroomPlus));
			bathroomPlus.click();
		}
	}

	public void increaseBalcony(int count) {
		for (int i = 0; i < count; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(balconyPlus));
			balconyPlus.click();
		}
	}

	public void selectWaterSupply() {
		wait.until(ExpectedConditions.elementToBeClickable(waterSupplyDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(waterSupplyOption)).click();
	}

	public void selectPetAllowed() {
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", petAllowedYes);
	}

	public void selectGym() {
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", gymYes);
	}

	public void selectNonVeg() {
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", nonVegYes);
	}

	public void selectGatedSecurity() {
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", gatedSecurityYes);
	}

	public void selectWhoWillShowProperty() {
		wait.until(ExpectedConditions.elementToBeClickable(showPropertyDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(showPropertyOption)).click();
	}

	public void selectPropertyCondition() {
		wait.until(ExpectedConditions.elementToBeClickable(propertyConditionDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(propertyConditionOption)).click();
	}

	public void enterDirections(String text) {
		wait.until(ExpectedConditions.visibilityOf(directionsInput));
		directionsInput.clear();
		directionsInput.sendKeys(text);
	}

	// 🔥 Safe click for amenities (same pattern you used)
	public void selectAmenities() {

		// Lift
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lift);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lift));
			lift.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lift);
		}

		// Swimming Pool
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", swimmingPool);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(swimmingPool));
			swimmingPool.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", swimmingPool);
		}
	}

	public void clickSaveAndContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton)).click();
	}

	public void clickBack() {
		wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
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