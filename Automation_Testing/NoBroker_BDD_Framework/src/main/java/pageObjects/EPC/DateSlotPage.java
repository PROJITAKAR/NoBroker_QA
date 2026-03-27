package pageObjects.EPC;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DateSlotPage {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Tomorrow']")
    WebElement datePicker;

    @FindBy(xpath = "//span[text()='9 AM - 9:30 AM']")
    WebElement firstAvailableSlot;

    @FindBy(id = "slots-proceed-mobile-as")
    WebElement proceedButton;
    
    @FindBy(xpath="//div[text()='Change']")
    WebElement Change;
    
    @FindBy(xpath="//div[text()='Add New Address']")
    WebElement AddNewAddress;

    public DateSlotPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDate() {
        datePicker.click();
    }

    public void selectFirstSlot() {
        firstAvailableSlot.click();
    }
    
    public void clickChange() {
    	Change.click();
    }
    
    public void clickAddAddress() {
    	AddNewAddress.click();
    }

    public void clickProceed() {
        proceedButton.click();
    }
}
