package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static ThreadLocal<String> browserName = new ThreadLocal<>();


    // Initialize driver
    public static void initDriver(String browser) {
    	

        if (browser == null) {
            browser = "chrome";
        }

        browserName.set(browser);

        WebDriver localDriver;

        switch (browser.toLowerCase()) {

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                localDriver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                localDriver = new FirefoxDriver(firefoxOptions);
                break;
                
            case "chrome":
            default:
            	ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--disable-extensions");
                localDriver = new ChromeDriver(chromeOptions);
                break;
        }

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.set(localDriver);
    }

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Get browser name for current thread
    public static String getBrowser() {
    	String b = browserName.get();
        return (b != null) ? b : "chrome";
    }

    // Quit driver safely
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();          
            browserName.remove();     
        }
    }
}