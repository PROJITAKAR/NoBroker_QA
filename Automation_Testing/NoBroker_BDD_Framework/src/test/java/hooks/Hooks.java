package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	    Thread.sleep(5000); // wait for session restore
	}
	// Only login if needed
	@Before(value = "@LoginRequired", order = 2)
	public void loginSetup() throws Exception {
		Thread.sleep(10000); 

		
	    // Check if already logged in using profile icon
	    boolean isLoggedIn = driver.findElements(
	        By.xpath("//div[@id='profile-icon']")
	    ).size() > 0;

	    if (!isLoggedIn) {

	        System.out.println("Not logged in → Performing login");

	        LoginPage loginPage = new LoginPage(driver);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

	        Thread.sleep(10000);
	        loginPage.loginClick();
	        Thread.sleep(5000);
	        loginPage.loginToNoBroker("9832717056"); // your number

	        System.out.println("Enter OTP manually and press ENTER...");
//	        System.in.read();   //  better than Thread.sleep
	        Thread.sleep(30000);
	        loginPage.continueClick();

	        // Save cookies AFTER successful login
	        CookieManager.saveCookies(driver);

	    } else {
	        System.out.println("Already logged in via cookies");
	    }
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}