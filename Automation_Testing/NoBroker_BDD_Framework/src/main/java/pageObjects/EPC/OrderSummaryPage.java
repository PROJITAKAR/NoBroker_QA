package pageObjects.EPC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Pay Now']")
    WebElement payNowButton;

    @FindBy(xpath = "//div[@class='md:border md:border-exit-inter-border md:rounded-xl']")
    WebElement summaryContainer;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSummaryDisplayed() {
        return summaryContainer.isDisplayed();
    }

    public void clickPayNow() {
        payNowButton.click();
    }
}