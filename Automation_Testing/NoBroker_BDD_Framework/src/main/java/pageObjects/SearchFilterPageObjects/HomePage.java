package pageObjects.SearchFilterPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[contains(@class,'nb-select__control')]")
    WebElement cityDropdown;

    @FindBy(id = "listPageSearchLocality")
    WebElement localityInput;


    By suggestionContainer = By.xpath("//*[@role='option']");

    @FindBy(xpath =
        "//button[normalize-space(text())='Search' or " +
        "normalize-space(text())='SEARCH' or " +
        "normalize-space(.)='Search' or " +
        "normalize-space(.)='SEARCH']"
    )
    WebElement searchButton;


    @FindBy(xpath = "//div[normalize-space()='Buy']")
    WebElement buyTab;

    @FindBy(xpath = "//div[normalize-space()='Rent']")
    WebElement rentTab;


    @FindBy(xpath = "//label[normalize-space()='Full House']")
    WebElement buyFullHouse;

    @FindBy(xpath = "//div[contains(text(),'BHK Type')]")
    WebElement bhkDropdown;

    @FindBy(xpath = "//div[contains(text(),'Property Status')]")
    WebElement propertyStatusDropdown;


    @FindBy(xpath = "//label[.//input[@id='PG']]")
    WebElement rentPG;

    @FindBy(xpath = "//label[.//input[@value='SHARED']]")
    WebElement rentFlatmates;


    public void selectCity(String cityName) {
        try {
            Thread.sleep(1500);

            WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(cityDropdown)
            );
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", dropdown
            );
            dropdown.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'nb-select__menu-list')]")
            ));

            By cityOption = By.xpath(
                "//div[contains(@class,'nb-select__menu-list')]" +
                "//div[contains(@class,'nb-select__option') and normalize-space(text())='" + cityName + "']"
            );

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(cityOption));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void selectLocality(String locality) {
        try {
            WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(localityInput)
            );

            Thread.sleep(500);
            input.click();
            input.clear();
            input.sendKeys(locality);

            Thread.sleep(2500);

            wait.until(ExpectedConditions.presenceOfElementLocated(suggestionContainer));

            List<WebElement> options = driver.findElements(suggestionContainer);

            if (!options.isEmpty()) {
                WebElement first = options.get(0);


                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", first);

            } else {
                System.out.println("[WARN] No locality suggestions found for: " + locality);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickSearch() {
        try {
            Thread.sleep(500);
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            try {
                btn.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void handleMetroPopup() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement skipBtn = shortWait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[contains(text(),'Skip')]")
                )
            );
            skipBtn.click();
        } catch (Exception e) {
        }
    }



    public void clickBuyTab() {
        wait.until(ExpectedConditions.elementToBeClickable(buyTab)).click();
    }

    public void clickRentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(rentTab)).click();
    }


    public void selectBuyFullHouse() {
        wait.until(ExpectedConditions.elementToBeClickable(buyFullHouse)).click();
    }

    public void isBHKDropdownVisible() {
        wait.until(ExpectedConditions.visibilityOf(bhkDropdown));
    }

    public void isPropertyStatusVisible() {
        wait.until(ExpectedConditions.visibilityOf(propertyStatusDropdown));
    }



    public void selectPGHostel() {
        wait.until(ExpectedConditions.elementToBeClickable(rentPG)).click();
    }

    public void selectFlatmates() {
        wait.until(ExpectedConditions.elementToBeClickable(rentFlatmates)).click();
    }
}
