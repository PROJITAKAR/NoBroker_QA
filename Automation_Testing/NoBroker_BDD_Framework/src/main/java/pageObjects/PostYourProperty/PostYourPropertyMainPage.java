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

	public void clickPostNow() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement postNowBtn = wait.until(
		        ExpectedConditions.elementToBeClickable(By.id("postNow"))
		);

		// Scroll into view
		((JavascriptExecutor) driver)
		        .executeScript("arguments[0].scrollIntoView(true);", postNowBtn);

		Thread.sleep(1000); // small buffer

		// Click using JS (bypass overlay)
		((JavascriptExecutor) driver)
		        .executeScript("arguments[0].click();", postNowBtn);
	}
}
