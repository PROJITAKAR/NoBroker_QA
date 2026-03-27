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
    @FindBy(id = "EVERYDAY")
    WebElement everydayOption;

//    @FindBy(xpath = "//div[contains(text(),'Weekday')]")
//    WebElement weekdayOption;
//
//    @FindBy(xpath = "//div[contains(text(),'Weekend')]")
//    WebElement weekendOption;

    // Time Inputs
    @FindBy(xpath = "//input[@placeholder='Start time']")
    WebElement startTimeInputdropdown;
    
  
    @FindBy(xpath = "//input[@placeholder='Start time']/../../following-sibling::div//li[text()='09:00 AM']")
    WebElement startTimeInputOption;

    @FindBy(xpath = "//input[@placeholder='End time']")
    WebElement endTimeInputdropdown;
    
    @FindBy(xpath = "//input[@placeholder='End time']/../../following-sibling::div//li[text()='06:00 PM']")
    WebElement endTimeInputOption;

//    // Available All Day Checkbox
//    @FindBy(xpath = "//input[@type='checkbox']")
//    WebElement availableAllDayCheckbox;

    // Buttons
    @FindBy(xpath = "//button[text()='Finish Posting']")
    WebElement finishPostingButton;

    @FindBy(xpath="//button[text()='Back']")
    WebElement backButton;

    // ================= ACTION METHODS =================

    public void selectEveryday() {
        everydayOption.click();
    }

//    public void selectWeekday() {
//        weekdayOption.click();
//    }
//
//    public void selectWeekend() {
//        weekendOption.click();
//    }

    public void enterStartTime(String time) {
        startTimeInputdropdown.click();
        startTimeInputOption.click();
    }

    public void enterEndTime(String time) {
        endTimeInputdropdown.click();
        endTimeInputOption.click();
        
    }

//    public void selectAvailableAllDay() {
//        availableAllDayCheckbox.click();
//    }

    public void clickFinishPosting() {
        finishPostingButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
    
    public void fillScheduleDetails(String day, String startTime, String endTime) throws InterruptedException {

        // Availability
        if (day.equalsIgnoreCase("Everyday")) {
            selectEveryday();
        }

        Thread.sleep(2000);

        // Start Time
        enterStartTime(startTime);
        Thread.sleep(2000);

        // End Time
        enterEndTime(endTime);
        Thread.sleep(2000);

        // Finish Posting
        clickFinishPosting();
        Thread.sleep(5000);

        System.out.println("Schedule Page completed");
    }
}