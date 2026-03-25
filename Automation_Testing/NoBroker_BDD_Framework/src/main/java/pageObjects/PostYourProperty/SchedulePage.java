package pageObjects.PostYourProperty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage {

    WebDriver driver;

    // Constructor
    public SchedulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Availability Options
    @FindBy(xpath = "//div[contains(text(),'Everyday')]")
    WebElement everydayOption;

    @FindBy(xpath = "//div[contains(text(),'Weekday')]")
    WebElement weekdayOption;

    @FindBy(xpath = "//div[contains(text(),'Weekend')]")
    WebElement weekendOption;

    // Time Inputs
    @FindBy(xpath = "//input[@placeholder='Start time']")
    WebElement startTimeInput;

    @FindBy(xpath = "//input[@placeholder='End time']")
    WebElement endTimeInput;

    // Available All Day Checkbox
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement availableAllDayCheckbox;

    // Buttons
    @FindBy(id = "finishPosting")
    WebElement finishPostingButton;

    @FindBy(id = "back")
    WebElement backButton;

    // ================= ACTION METHODS =================

    public void selectEveryday() {
        everydayOption.click();
    }

    public void selectWeekday() {
        weekdayOption.click();
    }

    public void selectWeekend() {
        weekendOption.click();
    }

    public void enterStartTime(String time) {
        startTimeInput.clear();
        startTimeInput.sendKeys(time);
        startTimeInput.sendKeys(Keys.ENTER);
    }

    public void enterEndTime(String time) {
        endTimeInput.clear();
        endTimeInput.sendKeys(time);
        endTimeInput.sendKeys(Keys.ENTER);
    }

    public void selectAvailableAllDay() {
        availableAllDayCheckbox.click();
    }

    public void clickFinishPosting() {
        finishPostingButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
}