package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {

    WebDriver driver;

    // Constructor
    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Success Message
    @FindBy(xpath = "//div[text()='Congratulations!']")
    WebElement successMessage;

//    // Sub message
//    @FindBy(xpath = "//div[contains(text(),'successfully posted your property')]")
//    WebElement subMessage;

    // Buttons
    @FindBy(id = "editProperty")
    WebElement editButton;

    @FindBy(id = "previewListing")
    WebElement previewListingButton;

//    // Optional section (Rentometer)
//    @FindBy(xpath = "//div[contains(text(),'Rentometer')]")
//    WebElement rentometerSection;

    // ================= ACTION METHODS =================

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

//    public boolean isSubMessageDisplayed() {
//        return subMessage.isDisplayed();
//    }

    public void clickEdit() {
        editButton.click();
    }

    public void clickPreviewListing() {
        previewListingButton.click();
    }

//    public boolean isRentometerVisible() {
//        return rentometerSection.isDisplayed();
//    }
    
    public void verifyAndHandleSuccess() throws InterruptedException {

        // Verify success message
        if (isSuccessMessageDisplayed()) {
            System.out.println("✅ Property posted successfully");
        } else {
            throw new AssertionError("❌ Success message not displayed");
        }

        Thread.sleep(2000);

        // Optional action (you can choose one)
        // clickEdit();
         clickPreviewListing();

        System.out.println("✅ Success Page verified");
    }
}