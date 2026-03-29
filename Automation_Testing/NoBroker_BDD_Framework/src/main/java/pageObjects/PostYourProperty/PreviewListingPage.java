package pageObjects.PostYourProperty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviewListingPage {

    WebDriver driver;

    // Constructor
    public PreviewListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    @FindBy(xpath = "//h1[contains(text(),'BHK')]")
    WebElement propertyTitle;

    @FindBy(xpath = "//div[contains(text(),'Rent')]/preceding-sibling::div")
    WebElement rentValue;

    @FindBy(xpath = "//div[contains(text(),'Deposit')]/preceding-sibling::div")
    WebElement depositValue;

    @FindBy(xpath = "//div[contains(text(),'Sq.Ft')]/preceding-sibling::div")
    WebElement areaValue;

    @FindBy(xpath = "//button[contains(text(),'Edit Property')]")
    WebElement editPropertyButton;

    @FindBy(xpath = "//button[contains(text(),'Shortlist')]")
    WebElement shortlistButton;

    @FindBy(xpath = "//button[contains(text(),'Add Photos')]")
    WebElement addPhotosButton;

    @FindBy(xpath = "//div[contains(text(),'Preferred Tenant')]/preceding-sibling::div")
    WebElement preferredTenant;

    @FindBy(xpath = "//div[contains(text(),'Parking')]/preceding-sibling::div")
    WebElement parking;

    // ================= ACTION METHODS =================

    public String getPropertyTitle() {
        try {
            return propertyTitle.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", propertyTitle);
        }
    }

    public String getRent() {
        try {
            return rentValue.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", rentValue);
        }
    }

    public String getDeposit() {
        try {
            return depositValue.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", depositValue);
        }
    }

    public String getArea() {
        try {
            return areaValue.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", areaValue);
        }
    }

    public String getPreferredTenant() {
        try {
            return preferredTenant.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", preferredTenant);
        }
    }

    public String getParking() {
        try {
            return parking.getText();
        } catch (Exception e) {
            return (String) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].innerText;", parking);
        }
    }

    public void clickEditProperty() {
        try {
            editPropertyButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", editPropertyButton);
        }
    }

    public void clickShortlist() {
        try {
            shortlistButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", shortlistButton);
        }
    }

    public void clickAddPhotos() {
        try {
            addPhotosButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", addPhotosButton);
        }
    }
}