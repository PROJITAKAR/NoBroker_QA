package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ================= COMMON =================

    @FindBy(xpath = "//div[contains(@class,'nb-select__control')]")
    WebElement cityDropdown;

    @FindBy(xpath = "//div[contains(@class,'nb-select__menu-list')]//div[contains(text(),'Hyderabad')]")
    WebElement cityOption;

    @FindBy(id = "listPageSearchLocality")
    WebElement localityInput;

    By suggestions = By.xpath("//div[contains(@class,'autocomplete-dropdown-container')]//div");

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    // ================= TABS =================

    @FindBy(xpath = "//div[normalize-space()='Buy']")
    WebElement buyTab;

    @FindBy(xpath = "//div[normalize-space()='Rent']")
    WebElement rentTab;

    // ================= BUY TAB =================

    @FindBy(xpath = "//label[normalize-space()='Full House']")
    WebElement buyFullHouse;

    @FindBy(xpath = "//label[normalize-space()='Land/Plot']")
    WebElement buyLandPlot;

    @FindBy(xpath = "//div[contains(text(),'BHK Type')]")
    WebElement bhkDropdown;

    @FindBy(xpath = "//div[contains(text(),'Property Status')]")
    WebElement propertyStatusDropdown;

    // ================= RENT TAB =================

    @FindBy(xpath = "//label[.//input[@id='PG']]")
    WebElement rentPG;

    @FindBy(xpath = "//label[.//input[@value='SHARED']]")
    WebElement rentFlatmates;

    @FindBy(xpath = "//div[contains(text(),'Tenant Type')]")
    WebElement tenantTypeDropdown;

    @FindBy(xpath = "//div[contains(text(),'Room Type')]")
    WebElement roomTypeDropdown;

    // =========================================================
    // ================= COMMON ACTIONS =========================
    // =========================================================

    public void selectCity(String cityName) {
        wait.until(ExpectedConditions.elementToBeClickable(cityDropdown)).click();

        By city = By.xpath("//div[contains(@class,'nb-select__menu-list')]//div[contains(text(),'" + cityName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(city)).click();
    }

    public void selectLocality(String locality) {
        localityInput.clear();
        localityInput.sendKeys(locality);

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestions)
        );

        if (!options.isEmpty()) {
            options.get(0).click();
        }
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    // =========================================================
    // ================= TAB ACTIONS ============================
    // =========================================================

    public void clickBuyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(buyTab)).click();
    }

    public void clickRentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(rentTab)).click();
    }

    // =========================================================
    // ================= BUY FLOW ===============================
    // =========================================================

    public void selectBuyFullHouse() {
        wait.until(ExpectedConditions.elementToBeClickable(buyFullHouse)).click();
    }

    public void selectBuyLandPlot() {
        wait.until(ExpectedConditions.elementToBeClickable(buyLandPlot)).click();
    }

    public void openBHKDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(bhkDropdown)).click();
    }

    public void openPropertyStatusDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(propertyStatusDropdown)).click();
    }

    // =========================================================
    // ================= RENT FLOW ==============================
    // =========================================================

    public void selectPGHostel() {
        wait.until(ExpectedConditions.elementToBeClickable(rentPG)).click();
    }

    public void selectFlatmates() {
        wait.until(ExpectedConditions.elementToBeClickable(rentFlatmates)).click();
    }

    public void openTenantTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(tenantTypeDropdown)).click();
    }

    public void openRoomTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(roomTypeDropdown)).click();
    }
}