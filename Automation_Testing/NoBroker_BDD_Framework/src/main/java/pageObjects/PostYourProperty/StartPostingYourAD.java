package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPostingYourAD {
	WebDriver driver;

	// Locate Elements
	@FindBy(xpath = "//div[@id='citySelectContainer']")
	WebElement citySelector;

	@FindBy(xpath = "//div[text()='Pune']")
	WebElement selectedCity;

	@FindBy(xpath = "//div[@id='citySelectContainer']/../../../following-sibling::div//button")
	WebElement startPost;

	@FindBy(xpath = "//span[contains(text(),'Please select a valid city')]")
	WebElement cityError;
	
	

	public StartPostingYourAD(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void clickCityDropDown() throws InterruptedException {
		Thread.sleep(500);

		try {
			citySelector.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", citySelector);
		}

	}
	
	

	public void selectCity() throws InterruptedException {
		Thread.sleep(500);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By cityLocator = By.xpath("//div[text()='Pune']");

		WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));

		try {
			city.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", city);
		}
	}
	
	

	public void clickStartPost() {
		try {
			startPost.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", startPost);
		}
	}
	
	

	public void goToPropertyDetailsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(citySelector)).click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", citySelector);
		}
		By cityLocator = By.xpath("//div[text()='Pune']");
		WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));

		try {
			city.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", city);
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(startPost)).click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", startPost);
		}

		System.out.println("✅ Navigated to Property Details Page");
	}
	
	

	public boolean isCityErrorDisplayed() {
		try {
			return cityError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	

	public String getCityErrorMessage() {
		try {
			return cityError.getText();
		} catch (Exception e) {
			return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", cityError);
		}
	}
}