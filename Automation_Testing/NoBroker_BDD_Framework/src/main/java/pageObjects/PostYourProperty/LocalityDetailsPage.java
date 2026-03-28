package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalityDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LocalityDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= LOCATORS =================

    @FindBy(id = "propertyLocality")
    WebElement localityDropdown;
    
    @FindBy(xpath= "//div[@id='autocomplete-dropdown-container']/div[1]")
    WebElement localityInput;

    @FindBy(id = "street")
    WebElement landmarkInput;

    @FindBy(id = "back")
    WebElement backButton;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    // ================= ACTION METHODS =================

    public void enterLocality(String locality) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(localityDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(localityDropdown));

        localityDropdown.clear();
        localityDropdown.sendKeys(locality);
        wait.until(ExpectedConditions.visibilityOf(localityInput));
        wait.until(ExpectedConditions.elementToBeClickable(localityInput));

        localityInput.click();
    }

    public void enterLandmark(String landmark) {

        wait.until(ExpectedConditions.visibilityOf(landmarkInput));
        wait.until(ExpectedConditions.elementToBeClickable(landmarkInput));

        landmarkInput.clear();
        landmarkInput.sendKeys(landmark);
    }

    public void clickSaveAndContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
        saveAndContinueButton.click();
    }

    public void clickBack() {

        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }

    public void fillLocalityDetails(String locality, String landmark) throws InterruptedException {

        enterLocality(locality);
        Thread.sleep(2000); // kept

        enterLandmark(landmark);
        Thread.sleep(2000); // kept

        clickSaveAndContinue();
        Thread.sleep(5000); // kept

        System.out.println("✅ Locality Details filled and submitted");
    }
}