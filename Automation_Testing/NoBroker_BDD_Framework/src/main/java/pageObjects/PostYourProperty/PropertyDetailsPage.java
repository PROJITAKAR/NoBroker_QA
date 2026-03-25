package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage {

    WebDriver driver;

    // Constructor
    public PropertyDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= DROPDOWNS =================

    // Apartment Type
    @FindBy(xpath = "//div[@id='apartmentType']//div[text()='Select']")
    WebElement apartmentTypeDropdown;

    @FindBy(xpath = "//div[@id='apartmentType']//div[text()='Independent House/Villa']")
    WebElement apartmentTypeOption;


    // BHK
    @FindBy(xpath = "//div[@id='bhkType']//div[text()='Select']")
    WebElement bhkDropdown;

    @FindBy(xpath = "//div[@id='bhkType']//div[text()='2 BHK']")
    WebElement bhkOption;


//    // Floor
//    @FindBy(xpath = "//div[@id='commercialFloorSearch']//div[text()='Select']")
//    WebElement floorDropdown;
//
//    @FindBy(xpath = "//div[@id='commercialFloorSearch']//div[text()='1']")
//    WebElement floorOption;


    // Total Floor
    @FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='Select']")
    WebElement totalFloorDropdown;

    @FindBy(xpath = "//div[@id='commercialTotalSearch']//div[text()='3']")
    WebElement totalFloorOption;


    // Property Age
    @FindBy(xpath = "//div[@id='propertyAge']//div[text()='Select']")
    WebElement propertyAgeDropdown;

    @FindBy(xpath = "//div[@id='propertyAge']//div[text()='5 to 10 year']")
    WebElement propertyAgeOption;


    // Facing
    @FindBy(xpath = "//div[@id='propertyFacing']//div[text()='Select']")
    WebElement facingDropdown;

    @FindBy(xpath = "//div[@id='propertyFacing']//div[text()='East']")
    WebElement facingOption;


    // Built Up Area
    @FindBy(id = "propertySize")
    WebElement builtUpAreaInput;
    
    //Save & Continue
    @FindBy(id="saveAndContinue")
    WebElement SaveAndContinue;


    // ================= ACTION METHODS =================

    public void selectApartmentType() {
        apartmentTypeDropdown.click();
        apartmentTypeOption.click();
    }

    public void selectBHK() {
        bhkDropdown.click();
        bhkOption.click();
    }

//    public void selectFloor() {
//        floorDropdown.click();
//        floorOption.click();
//    }

    public void selectTotalFloor() {
        totalFloorDropdown.click();
        totalFloorOption.click();
    }

    public void selectPropertyAge() {
        propertyAgeDropdown.click();
        propertyAgeOption.click();
    }

    public void selectFacing() {
        facingDropdown.click();
        facingOption.click();
    }

    public void enterBuiltUpArea(String area) {
        builtUpAreaInput.clear();
        builtUpAreaInput.sendKeys(area);
    }
    
    public void clickSaveAndContinue() {
    	SaveAndContinue.click();
    }
}