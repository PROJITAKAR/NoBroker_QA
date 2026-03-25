package pageObjects.PackersAndMoversPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlotBookingPage {

	WebDriver driver;

    public SlotBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Valid Slot Booking
    @FindBy(xpath="//div[text()='06' and text()='Apr']")
    private WebElement date;
    
    @FindBy(xpath="//div[text()='2PM-3PM']")
    private WebElement validTime;
    
    @FindBy(xpath="//button//div[text()='Confirm']")
    private WebElement confirmBtn;
    
    public void selectDate() {
    	date.click();
    }
    
    public void selectValidTime() {
    	validTime.click();
    }
    
    public void confirm() {
    	confirmBtn.click();
    }
    
    //Invalid Slot Booking
    @FindBy(xpath="//div[text()='Tomorrow']")
    private WebElement invalidDate;
    
    public void selectInvalidDate() {
    	invalidDate.click();
    }
}
