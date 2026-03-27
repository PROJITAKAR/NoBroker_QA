package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadMediaPage {

    WebDriver driver;

    // Constructor
    public UploadMediaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================

    // Upload Photo Input
    @FindBy(xpath = "//label[@for='uploadImage']/input")
    WebElement uploadImageInput;

    // Upload Video Input
    @FindBy(xpath = "//label[@for='uploadVideo']/input")
    WebElement uploadVideoInput;

    // Save & Continue
    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    // ================= ACTION METHODS =================

    public void uploadImage(String filePath) {
        uploadImageInput.sendKeys(filePath);
    }

    public void uploadVideo(String filePath) {
        uploadVideoInput.sendKeys(filePath);
    }

    public void clickSaveAndContinue() {
        saveAndContinueButton.click();
    }

    // 🔥 Combined flow (same as your other pages)
    public void uploadMedia(String filePath) throws InterruptedException {

        uploadImage(filePath);   // upload photo
        Thread.sleep(3000);

        clickSaveAndContinue();
        Thread.sleep(5000);

        System.out.println("✅ Media uploaded successfully");
    }
}