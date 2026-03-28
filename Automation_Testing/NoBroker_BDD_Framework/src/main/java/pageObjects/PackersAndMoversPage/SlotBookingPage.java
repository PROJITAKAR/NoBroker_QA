package pageObjects.PackersAndMoversPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class SlotBookingPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public SlotBookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // =====================
    // STATIC VALUES
    // =====================
    private static final String DATE = "06 Apr";
    private static final String TIME = "9AM-10AM";

    // =====================
    // LOCATORS
    // =====================
    private By modal = By.id("modalContent");

    private By confirmBtn = By.xpath("//button//div[text()='Confirm']");

    // =====================
    // SELECT STATIC DATE
    // =====================
    public void selectDate() {

        try {
            // Wait for modal
            wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
            System.out.println("✅ Modal is visible");

            // Correct XPath for date
            By dateLocator = By.xpath(
                "//div[@id='modalContent']//div[contains(@class,'cursor-pointer')]//div[normalize-space()='" 
                + DATE + "']/parent::div"
            );

            WebElement dateCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dateLocator)
            );

            System.out.println("✅ Found date: " + DATE);

            // Scroll into view (important for horizontal UI)
            js.executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                dateCard
            );

            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(dateCard));

            // Click using JS (more reliable)
            js.executeScript("arguments[0].click();", dateCard);

            System.out.println("✅ Date selected: " + DATE);

        } catch (Exception e) {
            throw new RuntimeException("❌ Unable to select date: " + DATE, e);
        }
    }

    // =====================
    // SELECT STATIC TIME
    // =====================
    public void selectValidTime() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        WebElement timeElement = null;

        // Try exact time first
        try {
            timeElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='modalContent']//div[.//div[text()='" + TIME + "'] and not(contains(@class,'opacity-50'))]")
            ));
            System.out.println("✅ Found time slot: " + TIME);
        } catch (Exception e) {
            System.out.println("⚠️ Preferred time not available, selecting first available...");
        }

        // Fallback → first enabled slot
        if (timeElement == null) {
            List<WebElement> slots = driver.findElements(
                By.xpath("//div[@id='modalContent']//div[contains(@class,'rounded-0.8p') and not(contains(@class,'opacity-50'))]")
            );

            if (!slots.isEmpty()) {
                timeElement = slots.get(0);
                System.out.println("✅ Selected first available slot");
            }
        }

        if (timeElement == null) {
            throw new RuntimeException("❌ No valid time slot available");
        }

        js.executeScript("arguments[0].scrollIntoView(true);", timeElement);
        js.executeScript("arguments[0].click();", timeElement);
    }

    // =====================
    // CONFIRM BUTTON
    // =====================
    public void confirm() {

        WebElement confirmButton = wait.until(
            ExpectedConditions.elementToBeClickable(confirmBtn)
        );

        js.executeScript("arguments[0].click();", confirmButton);

        System.out.println("✅ Clicked Confirm button");
    }
}