package pageObjects.SearchFilterPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class PGresultsPage {

    WebDriver driver;
    WebDriverWait wait;

    public PGresultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "resetButton")
    WebElement resetButton;



    @FindBy(id = "pg_boys")
    WebElement boys;

    @FindBy(id = "sharing_single")
    WebElement single;

    @FindBy(id = "sharing_double")
    WebElement doubleRoom;

    @FindBy(id = "prefence_student")
    WebElement student;

    @FindBy(id = "food_lunch")
    WebElement lunch;

    @FindBy(xpath = "//div[text()='With Photos']")
    WebElement photos;



    By results = By.xpath("//div[contains(@class,'infinite-scroll-component')]//article");


    public void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }



    public void resetFilters() {
        safeClick(resetButton);
    }

    public void applyPGFilters() {
        safeClick(boys);
        safeClick(single);
        safeClick(doubleRoom);
        safeClick(student);
        safeClick(lunch);
        safeClick(photos);
    }

    public void clickFirstProperty() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(results)
        );

        if (!list.isEmpty()) {
            list.get(0).click();
        } else {
            throw new RuntimeException("No PG properties found");
        }
    }
}
