package pageObjects.PostYourProperty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocalityDetailsPage {

    WebDriver driver;

    // Constructor
    public LocalityDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================


    // Locality Search/Input
    @FindBy(id = "propertyLocality")
    WebElement localityInput;

    // Landmark / Street
    @FindBy(id = "street")
    WebElement landmarkInput;

    // Buttons
    @FindBy(id = "back")
    WebElement backButton;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    // ================= ACTION METHODS =================


    public void enterLocality(String locality) {
        localityInput.clear();
        localityInput.sendKeys(locality,Keys.ARROW_DOWN,Keys.ENTER);
    }


    public void enterLandmark(String landmark) {
        landmarkInput.clear();
        landmarkInput.sendKeys(landmark);
    }


    public void clickSaveAndContinue() {
        saveAndContinueButton.click();
    }

    public void clickBack() {
        backButton.click();
    }
    
    public void fillLocalityDetails(String locality, String landmark) throws InterruptedException {

        enterLocality(locality);
        Thread.sleep(2000);

        enterLandmark(landmark);
        Thread.sleep(2000);

        clickSaveAndContinue();
        Thread.sleep(5000);

        System.out.println("✅ Locality Details filled and submitted");
    }
}