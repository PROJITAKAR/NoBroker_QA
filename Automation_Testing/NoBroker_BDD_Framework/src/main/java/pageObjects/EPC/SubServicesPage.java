package pageObjects.EPC;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubServicesPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Add']")
    WebElement addButton;

    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedButton;

    public SubServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addService() {
        addButton.click();
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
