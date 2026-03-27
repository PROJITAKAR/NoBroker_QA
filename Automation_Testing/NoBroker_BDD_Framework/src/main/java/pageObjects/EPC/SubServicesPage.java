package pageObjects.EPC;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubServicesPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Add'][1]")
    WebElement addButton;

    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedButton;

    public SubServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addService() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement addBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[text()='Add'])[1]")
            )
        );

        // Scroll properly
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addBtn);

        // Small wait for UI stability
        wait.until(ExpectedConditions.elementToBeClickable(addBtn));

        try {
            addBtn.click();
        } catch (Exception e) {
            // fallback click
            js.executeScript("arguments[0].click();", addBtn);
        }

        System.out.println("Clicked Add button");
    }

    public boolean isProceedButtonDisplayed() {
        try {
            return proceedButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProceed() {
        proceedButton.click();
    }
}
