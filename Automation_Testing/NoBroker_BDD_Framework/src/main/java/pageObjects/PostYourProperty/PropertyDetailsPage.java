package pageObjects.PostYourProperty;

import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyDetailsPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public PropertyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ================= ELEMENTS =================

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement clickYes;

	@FindBy(xpath = "//div[@id='apartmentType']//div[text()='Select']")
	WebElement apartmentTypeDropdown;

	@FindBy(xpath = "//div[@id='apartmentType']//div[text()='Independent House/Villa']")
	WebElement apartmentTypeOption;

	@FindBy(xpath = "//div[@id='bhkType']//div[text()='Select']")
	WebElement bhkDropdown;

	@FindBy(xpath = "//div[@id='bhkType']//div[text()='2 BHK']")
	WebElement bhkOption;

	@FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='Select']")
	WebElement totalFloorDropdown;

	@FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='3']")
	WebElement totalFloorOption;

	@FindBy(xpath = "//div[@id='propertyAge']//div[text()='Select']")
	WebElement propertyAgeDropdown;

	@FindBy(xpath = "//div[@id='propertyAge']//div[text()='5 to 10 year']")
	WebElement propertyAgeOption;

	@FindBy(xpath = "//div[@id='propertyFacing']//div[text()='Select']")
	WebElement facingDropdown;

	@FindBy(xpath = "//div[@id='propertyFacing']//div[text()='East']")
	WebElement facingOption;

	@FindBy(id = "propertySize")
	WebElement builtUpAreaInput;

	@FindBy(id = "saveAndContinue")
	WebElement saveAndContinue;

	@FindBy(xpath = "//div[@validationstate='error']")
	List<WebElement> validationErrors;

	// ================= WAIT UTIL =================

	private void waitForClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// ================= ACTION METHODS =================

	public void clickYesButton() throws Exception {

	    Thread.sleep(3000);

	    Robot robot = new Robot();

	    // 🔥 Step 1: Ensure cursor starts INSIDE browser
	    Point loc = apartmentTypeDropdown.getLocation();
	    Dimension size = apartmentTypeDropdown.getSize();

	    int insideX = loc.getX() + size.getWidth()/2;
	    int insideY = loc.getY() + size.getHeight()/2;

	    robot.mouseMove(insideX, insideY);
	    Thread.sleep(1000);

	    // 🔥 Step 2: Move OUTSIDE browser (TRIGGER)
	    Dimension windowSize = driver.manage().window().getSize();

	    robot.mouseMove(windowSize.getWidth() + 300, windowSize.getHeight() + 300);
	    Thread.sleep(2000);  // 🔥 IMPORTANT: let popup appear

	    // 🔥 Step 3: Now directly find popup (DON'T move back yet)
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement yesButton = wait.until(
	        ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Yes']"))
	    );

	    // 🔥 Step 4: Move slightly back near button ONLY IF needed
	    robot.mouseMove(insideX, insideY);
	    Thread.sleep(500);

	    yesButton.click();
	}

	public void selectApartmentType() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(apartmentTypeDropdown);
		apartmentTypeDropdown.click();

		waitForClick(apartmentTypeOption);
		apartmentTypeOption.click();
	}

	public void selectBHK() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(bhkDropdown);
		bhkDropdown.click();

		waitForClick(bhkOption);
		bhkOption.click();
	}

	public void selectTotalFloor() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(totalFloorDropdown);
		totalFloorDropdown.click();

		waitForClick(totalFloorOption);
		totalFloorOption.click();
	}

	public void selectPropertyAge() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(propertyAgeDropdown);
		propertyAgeDropdown.click();

		waitForClick(propertyAgeOption);
		propertyAgeOption.click();
	}

	public void selectFacing() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(facingDropdown);
		facingDropdown.click();

		waitForClick(facingOption);
		facingOption.click();
	}

	public void enterBuiltUpArea(String area) throws InterruptedException {
		Thread.sleep(2000);
		waitForVisibility(builtUpAreaInput);
		builtUpAreaInput.clear();
		builtUpAreaInput.sendKeys(area);
	}

	public void clickSaveAndContinue() throws InterruptedException {
		Thread.sleep(2000);
		waitForClick(saveAndContinue);
		saveAndContinue.click();
	}

	public boolean hasValidationError() {
		return validationErrors.size() > 0;
	}

	// ================= MAIN FLOW =================

	public void fillPropertyDetails(String area) throws Exception {

		Thread.sleep(5000); // kept

		clickYesButton();

		selectApartmentType();
		selectBHK();
		selectTotalFloor();
		selectPropertyAge();
		selectFacing();
		enterBuiltUpArea(area);
		clickSaveAndContinue();

		Thread.sleep(5000); // kept

		System.out.println("Property Details filled and submitted");
	}
}