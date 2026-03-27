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

public class PropertyDetailsPage {

	WebDriver driver;

	// Constructor
	public PropertyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ================= DROPDOWNS =================

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement clickYes;

	// Apartment Type
	@FindBy(xpath = "//div[@id='apartmentType']//div[text()='Select']")
	WebElement apartmentTypeDropdown;

	@FindBy(xpath = "//div[@id='apartmentType']//div[text()='Independent House/Villa']")
	WebElement apartmentTypeOption;

	// BHK
	@FindBy(xpath = "//div[@id='bhkType']//div[text()='Select']")
	WebElement bhkDropdown;

	@FindBy(xpath = "//div[@id='bhkType']//div[text()='2 BHK']")
	WebElement bhkOption;

//    // Floor
//    @FindBy(xpath = "//div[@id='commercialFloorSearch']//div[text()='Select']")
//    WebElement floorDropdown;
//
//    @FindBy(xpath = "//div[@id='commercialFloorSearch']//div[text()='1']")
//    WebElement floorOption;

	// Total Floor
	@FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='Select']")
	WebElement totalFloorDropdown;

	@FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='3']")
	WebElement totalFloorOption;

	// Property Age
	@FindBy(xpath = "//div[@id='propertyAge']//div[text()='Select']")
	WebElement propertyAgeDropdown;

	@FindBy(xpath = "//div[@id='propertyAge']//div[text()='5 to 10 year']")
	WebElement propertyAgeOption;

	// Facing
	@FindBy(xpath = "//div[@id='propertyFacing']//div[text()='Select']")
	WebElement facingDropdown;

	@FindBy(xpath = "//div[@id='propertyFacing']//div[text()='East']")
	WebElement facingOption;

	// Built Up Area
	@FindBy(id = "propertySize")
	WebElement builtUpAreaInput;

	// Save & Continue
	@FindBy(id = "saveAndContinue")
	WebElement SaveAndContinue;

	@FindBy(xpath = "//div[@validationstate='error']")
	List<WebElement> validationErrors;

	// ================= ACTION METHODS =================

	public void clickYesButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    By yesLocator = By.xpath("//button[text()='Yes']");

	    // 1️⃣ Wait for presence
	    WebElement yesBtn = wait.until(
	        ExpectedConditions.presenceOfElementLocated(yesLocator)
	    );

	    // 2️⃣ Wait for visibility
	    wait.until(ExpectedConditions.visibilityOf(yesBtn));

	    // 3️⃣ Wait for clickable
	    wait.until(ExpectedConditions.elementToBeClickable(yesBtn));

	    // 4️⃣ Click ONLY ONCE
	    yesBtn.click();
	}

	public void selectApartmentType() {
		apartmentTypeDropdown.click();
		apartmentTypeOption.click();
	}

	public void selectBHK() {
		bhkDropdown.click();
		bhkOption.click();
	}

//    public void selectFloor() {
//        floorDropdown.click();
//        floorOption.click();
//    }

	public void selectTotalFloor() {
		totalFloorDropdown.click();
		totalFloorOption.click();
	}

	public void selectPropertyAge() {
		propertyAgeDropdown.click();
		propertyAgeOption.click();
	}

	public void selectFacing() {
		facingDropdown.click();
		facingOption.click();
	}

	public void enterBuiltUpArea(String area) {
		builtUpAreaInput.clear();
		builtUpAreaInput.sendKeys(area);
	}

	public void clickSaveAndContinue() {
		SaveAndContinue.click();
	}

	public boolean hasValidationError() {
		return validationErrors.size() > 0;
	}

	public void fillPropertyDetails(String area) throws InterruptedException {

		clickYesButton();
		Thread.sleep(2000);

		selectApartmentType();
		Thread.sleep(2000);

		selectBHK();
		Thread.sleep(2000);

		selectTotalFloor();
		Thread.sleep(2000);

		selectPropertyAge();
		Thread.sleep(2000);

		selectFacing();
		Thread.sleep(2000);

		enterBuiltUpArea(area);
		Thread.sleep(2000);

		clickSaveAndContinue();
		Thread.sleep(5000);

		System.out.println("Property Details filled and submitted");
	}
}