package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostYourPropertyMainPage {
	WebDriver driver;

	// Locate Elements
	@FindBy(xpath = "//button[@id='postNow']")
	WebElement postNowBtn;

	// Constructor
	public PostYourPropertyMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickPostNow() {
		postNowBtn.click();
	}
}
