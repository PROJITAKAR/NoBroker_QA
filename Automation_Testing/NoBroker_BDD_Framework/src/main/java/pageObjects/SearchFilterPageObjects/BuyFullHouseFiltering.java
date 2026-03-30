package pageObjects.SearchFilterPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class BuyFullHouseFiltering {

    WebDriver driver;
    WebDriverWait wait;

    public BuyFullHouseFiltering(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "resetButton")
    WebElement resetButton;

    
    @FindBy(xpath = "//div[text()='1 BHK']")
    WebElement oneBHK;

    
    @FindBy(xpath = "//input[@id='prop_status_2']/parent::label")
    WebElement readyProperty;

    
    @FindBy(xpath = "//input[@id='furnishingFull']/parent::label")
    WebElement fullFurnish;

    @FindBy(xpath = "//input[@id='apartment']/parent::label")
    WebElement apartmentType;

    
    @FindBy(xpath = "//input[@id='parking_4_wheeler']/parent::label")
    WebElement fourWheeler;

    
    By results = By.xpath("//div[contains(@class,'infinite-scroll-component')]//article");


    public void resetFilters() {
        wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();
    }

    public void applyFilters() {
        wait.until(ExpectedConditions.elementToBeClickable(oneBHK)).click();
        wait.until(ExpectedConditions.elementToBeClickable(readyProperty)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fullFurnish)).click();
        wait.until(ExpectedConditions.elementToBeClickable(apartmentType)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fourWheeler)).click();
    }

    public void clickFirstProperty() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(results)
        );

        if (!list.isEmpty()) {
            list.get(0).click();
        } else {
            throw new RuntimeException("No properties found");
        }
    }
}