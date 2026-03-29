package pageObjects.PostYourProperty;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.HasCdp;
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

//	public void clickYesButton() throws Exception {
//
//	    Thread.sleep(3000);
//
//	    Robot robot = new Robot();
//
//	    // 🔥 Step 1: Ensure cursor starts INSIDE browser
//	    Point loc = apartmentTypeDropdown.getLocation();
//	    Dimension size = apartmentTypeDropdown.getSize();
//
//	    int insideX = loc.getX() + size.getWidth()/2;
//	    int insideY = loc.getY() + size.getHeight()/2;
//
//	    robot.mouseMove(insideX, insideY);
//	    Thread.sleep(1000);
//
//	    // 🔥 Step 2: Move OUTSIDE browser (TRIGGER)
//	    Dimension windowSize = driver.manage().window().getSize();
//
//	    robot.mouseMove(windowSize.getWidth() + 300, windowSize.getHeight() + 300);
//	    Thread.sleep(2000);  // 🔥 IMPORTANT: let popup appear
//
//	    // 🔥 Step 3: Now directly find popup (DON'T move back yet)
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    WebElement yesButton = wait.until(
//	        ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Yes']"))
//	    );
//
//	    // 🔥 Step 4: Move slightly back near button ONLY IF needed
//	    robot.mouseMove(insideX, insideY);
//	    Thread.sleep(500);
//
//	    yesButton.click();
//	}

	private void sendCdpMouseMove(HasCdp cdpDriver, double x, double y) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", "mouseMoved");
		params.put("x", x);
		params.put("y", y);
		params.put("pointerType", "mouse");
		cdpDriver.executeCdpCommand("Input.dispatchMouseEvent", params);
	}

	public void clickYesButton() throws InterruptedException, AWTException {
		Thread.sleep(5000);

		if (driver instanceof HasCdp) {
			HasCdp cdpDriver = (HasCdp) driver;

			// Step 1: Start inside viewport center
			sendCdpMouseMove(cdpDriver, 500.0, 400.0);
			Thread.sleep(500);

			// Step 2: Slide upward into tab bar / URL bar zone
			for (int step = 1; step <= 10; step++) {
				double y = 400 - (step * 60.0); // 400 → -200
				sendCdpMouseMove(cdpDriver, 500.0, y);
				Thread.sleep(80);
			}

		}  else {
			Thread.sleep(3000);

			Robot robot = new Robot();

			// 🔥 Step 1: Ensure cursor starts INSIDE browser
			Point loc = apartmentTypeDropdown.getLocation();
			Dimension size = apartmentTypeDropdown.getSize();

			int insideX = loc.getX() + size.getWidth() / 2;
			int insideY = loc.getY() + size.getHeight() / 2;

			robot.mouseMove(insideX, insideY);
			Thread.sleep(1000);

			// 🔥 Step 2: Move OUTSIDE browser (TRIGGER)
			Dimension windowSize = driver.manage().window().getSize();

			robot.mouseMove(windowSize.getWidth() + 300, windowSize.getHeight() + 300);
			Thread.sleep(2000); // 🔥 IMPORTANT: let popup appear
		}

		Thread.sleep(2500);

		WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']")));

		try {
			yesButton.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesButton);
		}
	}

	public void selectApartmentType() throws InterruptedException {
		Thread.sleep(500);
		try {
			waitForClick(apartmentTypeDropdown);
			apartmentTypeDropdown.click();

			waitForClick(apartmentTypeOption);
			apartmentTypeOption.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", apartmentTypeDropdown);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", apartmentTypeOption);
		}
	}

	public void selectBHK(String bhk) throws InterruptedException {
		Thread.sleep(500);

		try {
			waitForClick(bhkDropdown);
			bhkDropdown.click();

			WebElement option = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='bhkType']//div[text()='" + bhk + "']")));

			waitForClick(option);
			option.click();

		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bhkDropdown);

			WebElement option = driver.findElement(By.xpath("//div[@id='bhkType']//div[text()='" + bhk + "']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
		}
	}

	public void selectTotalFloor(String floor) throws InterruptedException {
		Thread.sleep(500);

		try {
			waitForClick(totalFloorDropdown);
			totalFloorDropdown.click();

			WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@id='commercialTotalSearch']//div[text()='" + floor + "']")));

			waitForClick(option);
			option.click();

		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", totalFloorDropdown);

			WebElement option = driver
					.findElement(By.xpath("//div[@id='commercialTotalSearch']//div[text()='" + floor + "']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
		}
	}

	public void selectPropertyAge(String age) throws InterruptedException {
		Thread.sleep(500);

		try {
			waitForClick(propertyAgeDropdown);
			propertyAgeDropdown.click();

			WebElement option = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='propertyAge']//div[text()='" + age + "']")));

			waitForClick(option);
			option.click();

		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyAgeDropdown);

			WebElement option = driver.findElement(By.xpath("//div[@id='propertyAge']//div[text()='" + age + "']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
		}
	}

	public void selectFacing(String facing) throws InterruptedException {
		Thread.sleep(500);

		try {
			waitForClick(facingDropdown);
			facingDropdown.click();

			WebElement option = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@id='propertyFacing']//div[text()='" + facing + "']")));

			waitForClick(option);
			option.click();

		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", facingDropdown);

			WebElement option = driver
					.findElement(By.xpath("//div[@id='propertyFacing']//div[text()='" + facing + "']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
		}
	}

	public void enterBuiltUpArea(String area) throws InterruptedException {
		Thread.sleep(500);
		try {
			waitForVisibility(builtUpAreaInput);
			builtUpAreaInput.clear();
			builtUpAreaInput.sendKeys(area);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + area + "';", builtUpAreaInput);
		}
	}

	public void clickSaveAndContinue() throws InterruptedException {
		Thread.sleep(500);
		try {
			waitForClick(saveAndContinue);
			saveAndContinue.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveAndContinue);
		}
	}

	public boolean hasValidationError() {
		return validationErrors.size() > 0;
	}

	// ================= MAIN FLOW =================

	public void fillPropertyDetails(String area) throws Exception {

		Thread.sleep(5000); // kept

		clickYesButton();

		selectApartmentType(); // static
		selectBHK("2 BHK"); // default
		selectTotalFloor("3");
		selectPropertyAge("5 to 10 year");
		selectFacing("East");
		enterBuiltUpArea(area);

		clickSaveAndContinue();

		Thread.sleep(5000); // kept

		System.out.println("Property Details filled and submitted");
	}
}