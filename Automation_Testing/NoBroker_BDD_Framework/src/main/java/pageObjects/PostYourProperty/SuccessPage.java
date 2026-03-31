package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public SuccessPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// ================= LOCATORS =================

	@FindBy(xpath = "//div[contains(text(),'Congratulations')]")
	WebElement successMessage;

	@FindBy(id = "editProperty")
	WebElement editButton;

	@FindBy(id = "previewListing")
	WebElement previewListingButton;


	// ================= ACTION METHODS =================

	public boolean isSuccessMessageDisplayed() {
		return successMessage.isDisplayed();
	}

	public void clickEdit() {
		editButton.click();
	}

	public void clickPreviewListing() {
		previewListingButton.click();
	}

	public String getSuccessMessageText() {
		return successMessage.getText();
	}

	public boolean areOptionsVisible() {
	    
	    try {
	        wait.until(ExpectedConditions.visibilityOf(editButton));
	        wait.until(ExpectedConditions.visibilityOf(previewListingButton));
	        return editButton.isDisplayed() && previewListingButton.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
}