package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import pageObjects.LoginPage;
import utils.DriverFactory;
import utils.CookieManager;
import org.openqa.selenium.By;

public class Hooks {

	WebDriver driver;

	@Before(order = 0)
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.nobroker.in/");
	}

	// Try loading cookies FIRST (skip login)
	@Before(order = 1)
	public void loadSession() throws InterruptedException {

		CookieManager.loadCookies(driver);
		driver.navigate().refresh();
		Thread.sleep(10000); // small wait
	}

	// Only login if needed
	@Before(value = "@LoginRequired", order = 2)
	public void loginSetup() throws Exception {

		Thread.sleep(10000);

		if (isLoggedIn()) {
			System.out.println("Already logged in via cookies");
			return;
		}

		System.out.println("Cookies invalid/expired → Performing login");

		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Thread.sleep(5000);
		loginPage.loginClick();
		Thread.sleep(3000);

		System.out.println("Enter OTP manually and press ENTER...");
		Thread.sleep(50000);

		loginPage.continueClick();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));
		
		Thread.sleep(2000);

		CookieManager.saveCookies(driver);
		Thread.sleep(8000);

	}

	private boolean isLoggedIn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));
			return profile.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

/*	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}*/
}