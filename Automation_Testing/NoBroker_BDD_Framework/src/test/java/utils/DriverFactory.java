package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    // 🔥 ThreadLocal for Driver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // 🔥 ThreadLocal for Browser
    private static ThreadLocal<String> browserName = new ThreadLocal<>();


    // Initialize driver
    public static void initDriver(String browser) {

        // store browser per thread
        browserName.set(browser);

        WebDriver localDriver;

<<<<<<< HEAD
	public static void quitDriver() {
//		if (driver != null) {
//			driver.quit();
//			driver = null;
//		}
//		driver.close();
	}
=======
        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                localDriver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                localDriver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                localDriver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        localDriver.manage().window().maximize();

        driver.set(localDriver);
    }

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Get browser name for current thread
    public static String getBrowser() {
        return browserName.get();
    }

    // Quit driver safely
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();          // 🔥 prevent memory leak
            browserName.remove();     // 🔥 equally important
        }
    }
>>>>>>> main
}