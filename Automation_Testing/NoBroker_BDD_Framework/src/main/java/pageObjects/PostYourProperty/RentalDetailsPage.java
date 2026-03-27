package pageObjects.PostYourProperty;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentalDetailsPage {

	WebDriver driver;

	// Constructor
	public RentalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ================= LOCATORS =================

	// Property available for
	@FindBy(xpath = "//label[@for='availableOnLeaseNo']/input")
	WebElement onlyRentOption;

	@FindBy(xpath = "//label[@for='availableOnLeaseYes']/input")
	WebElement onlyLeaseOption;

	// Rent & Deposit
	@FindBy(id = "rent")
	WebElement rentInput;

	@FindBy(id = "deposit")
	WebElement depositInput;

	// Rent Negotiable
	@FindBy(id = "negotiable")
	WebElement rentNegotiableCheckbox;

	// Monthly Maintenance
	@FindBy(xpath = "//div[@id='maintenance']//div[text()='Select']")
	WebElement maintenanceDropdown;

	@FindBy(xpath = "//div[@id='maintenance']//div[text()='Maintenance Included']")
	WebElement maintenanceOption;

	// Available From (Date)
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	WebElement availableFromInput;

	// Preferred Tenants
	@FindBy(id = "ANYONE")
	WebElement anyoneOption;

	@FindBy(id = "FAMILY")
	WebElement familyOption;

	@FindBy(id = "BACHELOR_MALE")
	WebElement bachelorMaleOption;

	@FindBy(id = "BACHELOR_FEMALE")
	WebElement bachelorFemaleOption;

	@FindBy(id = "COMPANY")
	WebElement companyOption;

	// Furnishing
	@FindBy(xpath = "//div[@id='furnishing']//div[text()='Select']")
	WebElement furnishingDropdown;

	@FindBy(xpath = "//div[@id='furnishing']//div[text()='Semi-furnished']")
	WebElement furnishingOption;

	// Parking
	@FindBy(xpath = "//div[@id='parkingType']//div[text()='Select']")
	WebElement parkingDropdown;

	@FindBy(xpath = "//div[@id='parkingType']//div[text()='Car']")
	WebElement parkingOption;

	// Description
	@FindBy(xpath = "//textarea[contains(@placeholder,'Write a few lines about your property')]")
	WebElement descriptionInput;

	// Button
	@FindBy(id = "saveAndContinue")
	WebElement saveAndContinueButton;

	@FindBy(id = "back")
	WebElement backButton;

	@FindBy(xpath = "//div[@validationstate='error']")
	List<WebElement> validationErrors;

	// ================= ACTION METHODS =================

	public void selectOnlyRent() {
		onlyRentOption.click();
	}

	public void enterRent(String rent) {
		rentInput.clear();
		rentInput.sendKeys(rent);
	}

	public void enterDeposit(String deposit) {
		depositInput.clear();
		depositInput.sendKeys(deposit);
	}

	public void clickRentNegotiable() {
		rentNegotiableCheckbox.click();
	}

	public void selectMaintenance() {
		maintenanceDropdown.click();
		maintenanceOption.click();
	}

	public void selectAvailableDate(String day) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1: Open calendar
		wait.until(ExpectedConditions.elementToBeClickable(availableFromInput)).click();

		// Step 2: Select date (ignore disabled dates)
		WebElement dateElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[not(contains(@class,'disabled')) and text()='" + day + "']")));

		dateElement.click();
	}

	public void selectFamilyTenant() {
		familyOption.click();
	}

	public void selectFurnishing() {
		furnishingDropdown.click();
		furnishingOption.click();
	}

	public void selectParking() {
		parkingDropdown.click();
		parkingOption.click();
	}

	public void enterDescription(String desc) {
		descriptionInput.clear();
		descriptionInput.sendKeys(desc);
	}

	public void clickSaveAndContinue() {
		saveAndContinueButton.click();
	}

	public void clickBack() {
		backButton.click();
	}
	
	public boolean hasValidationError() {
        return validationErrors.size() > 0;
    }
    

	public void fillRentalDetails(String rent, String deposit) throws InterruptedException {

		selectOnlyRent();
		Thread.sleep(2000);

		enterRent(rent);
		Thread.sleep(2000);

		enterDeposit(deposit);
		Thread.sleep(2000);

		selectMaintenance();
		Thread.sleep(2000);

		selectFamilyTenant();
		Thread.sleep(2000);

		selectFurnishing();
		Thread.sleep(2000);

		selectParking();
		Thread.sleep(2000);

		// selecting date (example: 1)
		selectAvailableDate("1");
		Thread.sleep(2000);

		clickSaveAndContinue();
		Thread.sleep(5000);

		System.out.println("✅ Rental Details filled and submitted");
	}
}