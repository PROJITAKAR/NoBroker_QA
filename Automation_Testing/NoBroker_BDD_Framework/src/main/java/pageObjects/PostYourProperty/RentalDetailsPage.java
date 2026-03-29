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

	@FindBy(xpath = "//label[@for='ANYONE']/span")
	WebElement anyoneOption;

	@FindBy(xpath = "//label[@for='FAMILY']/span")
	WebElement familyOption;

	@FindBy(xpath = "//label[@for='BACHELOR_MALE']/span")
	WebElement bachelorMaleOption;

	@FindBy(xpath = "//label[@for='BACHELOR_FEMALE']/span")
	WebElement bachelorFemaleOption;

	@FindBy(xpath = "//label[@for='COMPANY']/span")
	WebElement companyOption;

	@FindBy(xpath = "//div[@id='furnishing']")
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

	public void selectOnlyRent() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(onlyRentOption));
			onlyRentOption.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", onlyRentOption);
		}
		Thread.sleep(500);

	}

	public void enterRent(String rent) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(rentInput));
			wait.until(ExpectedConditions.elementToBeClickable(rentInput));
			rentInput.clear();
			rentInput.sendKeys(rent);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + rent + "';", rentInput);
		}
		Thread.sleep(500);

	}

	public void enterDeposit(String deposit) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(depositInput));
			wait.until(ExpectedConditions.elementToBeClickable(depositInput));
			depositInput.clear();
			depositInput.sendKeys(deposit);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + deposit + "';", depositInput);
		}
		Thread.sleep(500);

	}

	public void clickRentNegotiable() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(rentNegotiableCheckbox));
			rentNegotiableCheckbox.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", rentNegotiableCheckbox);
		}
		Thread.sleep(500);

	}

	public void selectMaintenance() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(maintenanceDropdown));
			maintenanceDropdown.click();

			wait.until(ExpectedConditions.elementToBeClickable(maintenanceOption));
			maintenanceOption.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", maintenanceDropdown);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", maintenanceOption);
		}
		Thread.sleep(500);

	}

	public void selectAvailableDate(String day) throws InterruptedException {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(availableFromInput)).click();

			WebElement dateElement = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[not(contains(@class,'disabled')) and text()='" + day + "']")));

			dateElement.click();
		} catch (Exception e) {

			WebElement dateElement = driver.findElement(By.xpath("//div[text()='" + day + "']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateElement);
		}
		Thread.sleep(500);

	}

	public void selectFamilyTenant() throws InterruptedException {

		// Scroll to element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", familyOption);

		try {
			wait.until(ExpectedConditions.elementToBeClickable(familyOption));
			familyOption.click();
		} catch (Exception e) {

			// 🔥 FORCE CLICK (bypass overlay)
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", familyOption);
		}
		Thread.sleep(500);

	}
	
	

	public void selectFurnishing() throws InterruptedException {
	    Thread.sleep(1000);

	    // Step 1: Scroll to and click the control to open dropdown
	    WebElement control = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[@id='furnishing']//div[contains(@class,'nb-select__control')]")
	    ));
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block:'center'});", control
	    );
	    Thread.sleep(500);

	    try {
	        control.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", control);
	    }

	    Thread.sleep(500);

	    // Step 2: Option renders in a PORTAL — search entire document, NOT inside #furnishing
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(@class,'nb-select__option')][normalize-space()='Semi-furnished']")
	    ));

	    try {
	        option.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	    }
		Thread.sleep(500);
	}

	public void selectParking() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(parkingDropdown));
			parkingDropdown.click();

			wait.until(ExpectedConditions.elementToBeClickable(parkingOption));
			parkingOption.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", parkingDropdown);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", parkingOption);
		}
		Thread.sleep(500);

	}

	public void enterDescription(String desc) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(descriptionInput));
			wait.until(ExpectedConditions.elementToBeClickable(descriptionInput));
			descriptionInput.clear();
			descriptionInput.sendKeys(desc);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + desc + "';", descriptionInput);
		}
		Thread.sleep(500);
	}

	public void clickSaveAndContinue() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
			saveAndContinueButton.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveAndContinueButton);
		}
		Thread.sleep(1000);

	}

	public void clickBack() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(backButton));
			backButton.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", backButton);
		}
	}

	public boolean hasValidationError() {
		return validationErrors.size() > 0;
	}

	// ================= MAIN FLOW =================

	public void fillRentalDetails(String rent, String deposit) throws InterruptedException {

		selectOnlyRent();

		enterRent(rent);

		enterDeposit(deposit);

		selectMaintenance();

		selectFamilyTenant();

		selectFurnishing();

		selectParking();

		selectAvailableDate("31");

		clickSaveAndContinue();

		System.out.println("✅ Rental Details filled and submitted");
	}

	public String getDepositValidationMessage() {

		wait.until(ExpectedConditions.visibilityOf(rentAndDepositeValidation));
		return rentAndDepositeValidation.getText();
	}
}