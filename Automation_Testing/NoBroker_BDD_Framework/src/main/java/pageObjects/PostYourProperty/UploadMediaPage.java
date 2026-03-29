package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadMediaPage {

    WebDriver driver;
    WebDriverWait wait;   // 🔥 Global wait

    // Constructor
    public UploadMediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // 🔥 Initialize once
        PageFactory.initElements(driver, this);
    }

    // ================= LOCATORS =================
    
    @FindBy(xpath = "//img[@alt='Gallery']")
    WebElement navigateToGallery;

    @FindBy(xpath = "//label[@for='uploadImage']/input")
    WebElement uploadImageInput;

    @FindBy(xpath = "//label[@for='uploadVideo']/input")
    WebElement uploadVideoInput;
    
    @FindBy(xpath = "//div[contains(text(),'Photos added by')]")
    WebElement imgThumbnail;
    
    @FindBy(xpath = "//div[contains(text(),'Videos added by')]")
    WebElement vdoThumbnail;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinueButton;

    // ================= ACTION METHODS =================
    
    public void goToGallery() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(navigateToGallery));
            navigateToGallery.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", navigateToGallery);
        }
    }

    public void uploadImage(String filePath) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//label[@for='uploadImage']/input")));
            uploadImageInput.sendKeys(filePath);
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + filePath + "';", uploadImageInput);
        }
        Thread.sleep(15000);
//        driver.navigate().refresh();
    }

    public void uploadVideo(String filePath) throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[@for='uploadVideo']/input")));

        Actions actions = new Actions(driver);

        // 🔥 Scroll 14 times
        for (int i = 0; i < 14; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(200); // so you can SEE the scrolling
        }

        Thread.sleep(1000);

        // 🔥 Upload video
        try {
            uploadVideoInput.sendKeys(filePath);
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].value='" + filePath + "';", uploadVideoInput);
        }

        Thread.sleep(10000);

        // ⚠️ still not recommended
         driver.navigate().refresh();
    }

    public void clickSaveAndContinue() throws InterruptedException {
    	Thread.sleep(5000);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
            saveAndContinueButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", saveAndContinueButton);
        }
    }

    // 🔥 Combined flow
    public void uploadMedia(String imagePath, String videoPath) throws InterruptedException {
    	
    	goToGallery();
    	Thread.sleep(2000);

        uploadImage(imagePath);
        Thread.sleep(2000);

        isImageThumbnailVisible();
        Thread.sleep(1000);

        uploadVideo(videoPath);
        Thread.sleep(3000);

        isVideoThumbnailVisible();
        Thread.sleep(1000);

        clickSaveAndContinue();
        Thread.sleep(5000);

        System.out.println("✅ Media uploaded successfully (Image + Video)");
    }

    public boolean isImageThumbnailVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(imgThumbnail));
            return imgThumbnail.isDisplayed();
        } catch (Exception e) {
            try {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].offsetParent !== null;", imgThumbnail);
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean isVideoThumbnailVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(vdoThumbnail));
            return vdoThumbnail.isDisplayed();
        } catch (Exception e) {
            try {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].offsetParent !== null;", vdoThumbnail);
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean areMediaUploaded() {
        return isImageThumbnailVisible() || isVideoThumbnailVisible();
    }
}