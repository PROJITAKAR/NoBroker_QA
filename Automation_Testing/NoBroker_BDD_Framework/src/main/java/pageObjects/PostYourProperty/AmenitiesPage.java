package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmenitiesPage {

    WebDriver driver;
    WebDriverWait wait;

    public AmenitiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // LOCATORS
    @FindBy(id = "inc-btn-bathroom-counter-input-filed")
    WebElement bathroomPlus;

    @FindBy(id = "inc-btn-balconie-counter-input-field")
    WebElement balconyPlus;

    @FindBy(id = "amenitiesPypForm-waterSupply-nbInput")
    WebElement waterSupplyDropdown;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-waterSupply-nbInput-container']//div[text()='Borewell']")
    WebElement waterSupplyOption;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-aea__PET-nbInput-container']//input[@value='true']")
    WebElement petAllowedYes;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-gym-nbInput-container']//input[@value='true']")
    WebElement gymYes;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-aea__NON_VEG_ALLOWED-nbInput-container']//input[@value='true']")
    WebElement nonVegYes;

    @FindBy(xpath = "//div[@id='amenitiesPypForm-aea__GATED_SECURITY-nbInput-container']//input[@value='true']")
    WebElement gatedSecurityYes;

    @FindBy(xpath = "//div[@id='aea__HOUSE_KEY_WITH-aea__HOUSE_KEY_WITH-nbInput']")
    WebElement showPropertyDropdown;

    @FindBy(xpath = "//div[@id='aea__HOUSE_KEY_WITH-aea__HOUSE_KEY_WITH-nbInput']/div/div//div[text()='Neighbours']")
    WebElement showPropertyOption;

    @FindBy(xpath = "//div[@id='CURRENT_SITUATION-CURRENT_SITUATION-nbInput']")
    WebElement propertyConditionDropdown;

    @FindBy(xpath = "//div[@id='CURRENT_SITUATION-CURRENT_SITUATION-nbInput']/div/div//div[text()='New Property']")
    WebElement propertyConditionOption;

    @FindBy(xpath = "//textarea[contains(@placeholder,'Eg. Take the road')]")
    WebElement directionsInput;

    @FindBy(xpath = "//input[@id='LIFT']")
    WebElement lift;

    @FindBy(xpath = "//input[@id='POOL']")
    WebElement swimmingPool;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "back")
    WebElement backButton;

    // METHODS

    public void increaseBathroom(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(bathroomPlus));
                bathroomPlus.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bathroomPlus);
            }
            Thread.sleep(500);
        }
    }

    public void increaseBalcony(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(balconyPlus));
                balconyPlus.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", balconyPlus);
            }
        }
        Thread.sleep(500);
    }

    public void selectWaterSupply() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(waterSupplyDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(waterSupplyOption)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waterSupplyDropdown);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waterSupplyOption);
        }
        Thread.sleep(500);
    }

    public void selectPetAllowed() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(petAllowedYes)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", petAllowedYes);
        }
        Thread.sleep(500);
    }

    public void selectGym() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(gymYes)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gymYes);
        }
        Thread.sleep(500);
    }

    public void selectNonVeg() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(nonVegYes)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nonVegYes);
        }
        Thread.sleep(500);
    }

    public void selectGatedSecurity() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(gatedSecurityYes)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gatedSecurityYes);
        }
        Thread.sleep(500);
    }

    public void selectWhoWillShowProperty() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(showPropertyDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(showPropertyOption)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showPropertyDropdown);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showPropertyOption);
        }
        Thread.sleep(500);
    }

    public void selectPropertyCondition() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(propertyConditionDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(propertyConditionOption)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyConditionDropdown);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", propertyConditionOption);
        }
        Thread.sleep(500);
    }

    public void enterDirections(String text) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(directionsInput));
            directionsInput.clear();
            directionsInput.sendKeys(text);
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + text + "';", directionsInput);
        }
        Thread.sleep(500);
    }

    public void selectAmenities() throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lift);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lift));
            lift.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lift);
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", swimmingPool);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(swimmingPool));
            swimmingPool.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", swimmingPool);
        }

        Thread.sleep(500);
    }

    public void clickSaveAndContinue() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveAndContinueButton);
        }
        Thread.sleep(1000);
    }

    public void clickBack() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", backButton);
        }
    }

    public void fillAmenitiesDetails() throws InterruptedException {

        increaseBathroom(1);
        increaseBalcony(1);
        selectWaterSupply();
        selectPetAllowed();
        selectGym();
        selectNonVeg();
        selectGatedSecurity();
        selectWhoWillShowProperty();
        selectPropertyCondition();
        enterDirections("Near main road");
        selectAmenities();
        clickSaveAndContinue();

        System.out.println("✅ Amenities Details filled and submitted");
    }
}