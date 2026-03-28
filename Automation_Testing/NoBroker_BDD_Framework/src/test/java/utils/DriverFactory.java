package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			ChromeOptions options = new ChromeOptions();

			// 🔥 Disable notifications
			options.addArguments("--disable-notifications");

			// Optional but useful
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-extensions");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void quitDriver() {
//		if (driver != null) {
//			driver.quit();
//			driver = null;
//		}
//		driver.close();
	}
}