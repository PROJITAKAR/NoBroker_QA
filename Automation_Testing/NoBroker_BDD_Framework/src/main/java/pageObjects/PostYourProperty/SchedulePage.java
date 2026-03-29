package pageObjects.PostYourProperty;

import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(name = "EVERYDAY")
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

    public void selectEveryday() throws InterruptedException {
        try {
            everydayOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", everydayOption);
        }
        Thread.sleep(2000);
    }

//    public void selectWeekday() {
//        weekdayOption.click();
//    }
//
//    public void selectWeekend() {
//        weekendOption.click();
//    }

    public void enterStartTime(String time) throws InterruptedException {
        try {
            startTimeInputdropdown.click();
            startTimeInputOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", startTimeInputdropdown);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", startTimeInputOption);
        }
        Thread.sleep(2000);
    }

    public void enterEndTime(String time) throws InterruptedException {
        try {
            endTimeInputdropdown.click();
            endTimeInputOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", endTimeInputdropdown);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", endTimeInputOption);
        }
        Thread.sleep(2000);
    }

//    public void selectAvailableAllDay() {
//        availableAllDayCheckbox.click();
//    }

    public void clickFinishPosting() throws InterruptedException {
        try {
            finishPostingButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", finishPostingButton);
        }
        Thread.sleep(5000);
    }

    public void clickBack() {
        try {
            backButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", backButton);
        }
    }
    
    public void fillScheduleDetails(String day, String startTime, String endTime) throws InterruptedException {

        // Availability
        if (day.equalsIgnoreCase("Everyday")) {
            selectEveryday();
        }

        // Start Time
        enterStartTime(startTime);
        
        // End Time
        enterEndTime(endTime);
        
        // Finish Posting
        clickFinishPosting();
        
        System.out.println("Schedule Page completed");
    }
}