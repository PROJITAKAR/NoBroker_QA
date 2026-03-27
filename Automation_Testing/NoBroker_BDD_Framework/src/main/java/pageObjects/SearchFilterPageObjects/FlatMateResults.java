package pageObjects.SearchFilterPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class FlatMateResults {

    WebDriver driver;
    WebDriverWait wait;

    public FlatMateResults(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//span[normalize-space()='Skip']")
    WebElement skipPopup;


    @FindBy(id = "resetButton")
    WebElement resetButton;

    @FindBy(id = "roomtype_shared")
    WebElement sharedRoom;

    @FindBy(id = "roomtype_single")
    WebElement singleRoom;



    @FindBy(id = "tenant_male")
    WebElement male;

    @FindBy(id = "tenant_female")
    WebElement female;



    @FindBy(id = "furnishingFull")
    WebElement furnishingFull;



    @FindBy(id = "apartment")
    WebElement apartment;

    @FindBy(id = "4-wheeler")
    WebElement fourWheeler;

    

    By results = By.xpath("//div[contains(@class,'infinite-scroll-component')]//article");



    public void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }



    public void handlePopup() {
        try {
            wait.until(ExpectedConditions.visibilityOf(skipPopup));
            skipPopup.click();
        } catch (Exception e) {
            System.out.println("Popup not present");
        }
    }

    public void resetFilters() {
        safeClick(resetButton);
    }

    public void applyFlatmateFilters() {
        safeClick(sharedRoom);
        safeClick(singleRoom);
        safeClick(male);
        safeClick(female);
        safeClick(furnishingFull);
        safeClick(apartment);
        safeClick(fourWheeler);
    }

    public void clickFirstProperty() {
        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(results)
        );

        if (!list.isEmpty()) {
            list.get(0).click();
        } else {
            throw new RuntimeException("No Flatmate properties found");
        }
    }
}
