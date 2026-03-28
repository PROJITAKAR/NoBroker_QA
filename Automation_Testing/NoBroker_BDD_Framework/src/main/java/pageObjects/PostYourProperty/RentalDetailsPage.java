package pageObjects.PostYourProperty;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentalDetailsPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public RentalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// ================= LOCATORS =================
	@FindBy(xpath = "//label[@for='availableOnLeaseNo']/input")
	WebElement onlyRentOption;

	@FindBy(xpath = "//label[@for='availableOnLeaseYes']/input")
	WebElement onlyLeaseOption;

	@FindBy(id = "rent")
	WebElement rentInput;

	@FindBy(id = "deposit")
	WebElement depositInput;

	@FindBy(id = "negotiable")
	WebElement rentNegotiableCheckbox;

	@FindBy(xpath = "//div[@id='maintenance']//div[text()='Select']")
	WebElement maintenanceDropdown;

	@FindBy(xpath = "//div[@id='maintenance']//div[text()='Maintenance Included']")
	WebElement maintenanceOption;

	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	WebElement availableFromInput;

	@FindBy(id = "//label[@for='ANYONE']/span")
	WebElement anyoneOption;

	@FindBy(xpath = "//label[@for='FAMILY']/span")
	WebElement familyOption;

	@FindBy(id = "//label[@for='BACHELOR_MALE']/span")
	WebElement bachelorMaleOption;

	@FindBy(id = "//label[@for='BACHELOR_FEMALE']/span")
	WebElement bachelorFemaleOption;

	@FindBy(id = "//label[@for='COMPANY']/span")
	WebElement companyOption;

	@FindBy(xpath = "//div[@id='furnishing']//div[text()='Select']")
	WebElement furnishingDropdown;

	@FindBy(xpath = "//div[@id='furnishing']//div[text()='Semi-furnished']")
	WebElement furnishingOption;

	@FindBy(xpath = "//div[@id='parkingType']//div[text()='Select']")
	WebElement parkingDropdown;

	@FindBy(xpath = "//div[@id='parkingType']//div[text()='Car']")
	WebElement parkingOption;

	@FindBy(xpath = "//textarea[contains(@placeholder,'Write a few lines about your property')]")
	WebElement descriptionInput;

	@FindBy(id = "saveAndContinue")
	WebElement saveAndContinueButton;

	@FindBy(id = "back")
	WebElement backButton;

	@FindBy(xpath = "//div[@validationstate='error']")
	List<WebElement> validationErrors;

	@FindBy(xpath = "//div[@validationstate='error']//span[contains(text(),'Deposit can not be less than Rent !')]")
	WebElement rentAndDepositeValidation;

	// ================= ACTION METHODS =================

	public void selectOnlyRent() {
		wait.until(ExpectedConditions.elementToBeClickable(onlyRentOption));
		onlyRentOption.click();
	}

	public void enterRent(String rent) {
		wait.until(ExpectedConditions.visibilityOf(rentInput));
		wait.until(ExpectedConditions.elementToBeClickable(rentInput));
		rentInput.clear();
		rentInput.sendKeys(rent);
	}

	public void enterDeposit(String deposit) {
		wait.until(ExpectedConditions.visibilityOf(depositInput));
		wait.until(ExpectedConditions.elementToBeClickable(depositInput));
		depositInput.clear();
		depositInput.sendKeys(deposit);
	}

	public void clickRentNegotiable() {
		wait.until(ExpectedConditions.elementToBeClickable(rentNegotiableCheckbox));
		rentNegotiableCheckbox.click();
	}

	public void selectMaintenance() {
		wait.until(ExpectedConditions.elementToBeClickable(maintenanceDropdown));
		maintenanceDropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(maintenanceOption));
		maintenanceOption.click();
	}

	public void selectAvailableDate(String day) {

		wait.until(ExpectedConditions.elementToBeClickable(availableFromInput)).click();

		WebElement dateElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[not(contains(@class,'disabled')) and text()='" + day + "']")));

		dateElement.click();
	}

	public void selectFamilyTenant() {

		// Scroll to element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", familyOption);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(familyOption));
			familyOption.click();
		} catch (Exception e) {

			// 🔥 FORCE CLICK (bypass overlay)
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", familyOption);
		}
	}

	public void selectFurnishing() {

		wait.until(ExpectedConditions.visibilityOf(furnishingDropdown));

		try {
			wait.until(ExpectedConditions.elementToBeClickable(furnishingDropdown));
			furnishingDropdown.click();
		} catch (Exception e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", furnishingDropdown);
		}

		wait.until(ExpectedConditions.elementToBeClickable(furnishingOption));
		furnishingOption.click();
	}

	public void selectParking() {
		wait.until(ExpectedConditions.elementToBeClickable(parkingDropdown));
		parkingDropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(parkingOption));
		parkingOption.click();
	}

	public void enterDescription(String desc) {
		wait.until(ExpectedConditions.visibilityOf(descriptionInput));
		wait.until(ExpectedConditions.elementToBeClickable(descriptionInput));
		descriptionInput.clear();
		descriptionInput.sendKeys(desc);
	}

	public void clickSaveAndContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
		saveAndContinueButton.click();
	}

	public void clickBack() {
		wait.until(ExpectedConditions.elementToBeClickable(backButton));
		backButton.click();
	}

	public boolean hasValidationError() {
		return validationErrors.size() > 0;
	}

	// ================= MAIN FLOW =================

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

		selectAvailableDate("31");
		Thread.sleep(2000);

		clickSaveAndContinue();
		Thread.sleep(5000);

		System.out.println("✅ Rental Details filled and submitted");
	}

	public String getDepositValidationMessage() {

		wait.until(ExpectedConditions.visibilityOf(rentAndDepositeValidation));
		return rentAndDepositeValidation.getText();
	}
}