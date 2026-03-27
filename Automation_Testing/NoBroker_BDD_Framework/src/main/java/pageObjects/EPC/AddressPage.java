package pageObjects.EPC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search your society or nearest landmark']")
    WebElement locationSearchBar;
    
    @FindBy(xpath="//div[text()='Confirm location']")
    WebElement ConfirmLoc;

    @FindBy(xpath = "//input[@id='houseNumber']")
    WebElement flatNoField;

    @FindBy(xpath = "//input[@id='address']")
    WebElement landmarkField;

    @FindBy(xpath = "//input[@id='submit-address']")
    WebElement proceedButton;
    
    @FindBy(xpath="//button[@id='saveAs'][1]")
    WebElement SaveAsHome;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchLocation(String location) {
        locationSearchBar.sendKeys(location);
    }

    public void enterFlatNo(String flatNo) {
        flatNoField.sendKeys(flatNo);
    }

    public void enterLandmark(String landmark) {
        landmarkField.sendKeys(landmark);
    }
    
    public void setSaveAs() {
    	SaveAsHome.click();
    }
    
    public void ClickConfirmLoc() {
    	ConfirmLoc.click();
    }

    public void clickProceed() {
        proceedButton.click();
    }
}