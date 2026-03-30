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

        // Click the first Add button
        WebElement addBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//button[text()='Add'])[1]")
            )
        );

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addBtn);
        wait.until(ExpectedConditions.elementToBeClickable(addBtn));

        try {
            addBtn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", addBtn);
        }

        System.out.println("Clicked Add button");

        // Check if overlay appeared
        try {
            // Wait for overlay to appear
            WebElement overlay = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='modalContent']")
                )
            );

            System.out.println("Overlay detected — selecting option and clicking Add");

            // Click Add inside the overlay (first option)
            WebElement overlayAddBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='modalContent']//div[text()='Add']")
                )
            );
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", overlayAddBtn);
            overlayAddBtn.click();

            System.out.println("Clicked Add inside overlay");

            // Click Proceed inside the overlay
            WebElement overlayProceedBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='modalContent']//button[@id='add-ons-proceed']")
                )
            );

            // Wait until Proceed is enabled (it starts disabled)
            wait.until(ExpectedConditions.attributeToBe(
                By.xpath("//button[@id='add-ons-proceed']"), "disabled", ""
            ));

            js.executeScript("arguments[0].click();", overlayProceedBtn);
            System.out.println("Clicked Proceed inside overlay");

        } catch (Exception e) {
            // No overlay appeared — item was added directly
            System.out.println("No overlay — item added directly");
        }
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
