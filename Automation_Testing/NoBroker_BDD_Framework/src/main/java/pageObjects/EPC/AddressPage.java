package pageObjects.EPC;

import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedButton;
    
    @FindBy(xpath="//button[@id='saveAs'][1]")
    WebElement SaveAsHome;
    
    @FindBy(xpath="//button[@id='saveAs'][2]")
    WebElement SaveAsWork;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchAndSelectLocation(String location) throws InterruptedException {
        locationSearchBar.sendKeys(location);
        

            Thread.sleep(4000); 
        

        locationSearchBar.sendKeys(Keys.ARROW_DOWN);
        locationSearchBar.sendKeys(Keys.ENTER);
        
        Thread.sleep(2000);
    }

    public void enterFlatNo(String flatNo) {
        flatNoField.sendKeys(flatNo);
    }

    public void enterLandmark(String landmark) {
        landmarkField.sendKeys(landmark);
    }
    
    public void setSaveAsHome() {
    	SaveAsHome.click();
    }
    
    public void setSaveAsWork() {
    	SaveAsWork.click();
    }
    
    public void ClickConfirmLoc() {
    	ConfirmLoc.click();
    }

    public void clickProceed() {
        proceedButton.click();
    }
    
    
}