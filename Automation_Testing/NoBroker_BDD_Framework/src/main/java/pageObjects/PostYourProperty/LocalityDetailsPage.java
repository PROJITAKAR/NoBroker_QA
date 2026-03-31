package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@id='autocomplete-dropdown-container']/div[1]")
    WebElement localityInput;

    @FindBy(id = "street")
    WebElement landmarkInput;

    @FindBy(id = "back")
    WebElement backButton;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    // ================= ACTION METHODS =================
    
    public void enterLocality(String locality) throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOf(localityDropdown));
            wait.until(ExpectedConditions.elementToBeClickable(localityDropdown));

            localityDropdown.clear();
            localityDropdown.sendKeys(locality);

            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='autocomplete-dropdown-container']//div[1]")));

            suggestion.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + locality + "';", localityDropdown);

            WebElement suggestion = driver.findElement(
                    By.xpath("//div[@id='autocomplete-dropdown-container']//div[1]"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", suggestion);
        }

        Thread.sleep(500);
    }

    public void enterLandmark(String landmark) throws InterruptedException {

        try {
            wait.until(ExpectedConditions.visibilityOf(landmarkInput));
            wait.until(ExpectedConditions.elementToBeClickable(landmarkInput));

            landmarkInput.clear();
            landmarkInput.sendKeys(landmark);

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + landmark + "';", landmarkInput);
        }

        Thread.sleep(500);
    }

    public void clickSaveAndContinue() throws InterruptedException {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
            saveAndContinueButton.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", saveAndContinueButton);
        }

        Thread.sleep(1000);
    }

    public void clickBack() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(backButton));
            backButton.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", backButton);
        }
    }

    public void fillLocalityDetails(String locality, String landmark) throws InterruptedException {

        enterLocality(locality);

        enterLandmark(landmark);

        clickSaveAndContinue();

        System.out.println("Locality Details filled and submitted");
    }
}