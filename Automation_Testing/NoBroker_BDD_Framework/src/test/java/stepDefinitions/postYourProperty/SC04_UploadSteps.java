package stepDefinitions.postYourProperty;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import pageObjects.PostYourProperty.UploadMediaPage;
import utils.DriverFactory;

public class SC04_UploadSteps {

    WebDriver driver = DriverFactory.getDriver();
    UploadMediaPage uploadPage = new UploadMediaPage(driver);

    @When("the user uploads {string} and {string} \\(each under 5MB)")
    public void upload_files(String file1, String file2) throws InterruptedException {

        // 🔹 Provide full path (IMPORTANT)
        String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\" + file1;
        String videoPath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\" + file2;

        uploadPage.uploadImage(imagePath);
        Thread.sleep(2000);

        uploadPage.uploadVideo(videoPath);
        Thread.sleep(3000);

        System.out.println("Uploaded: " + file1 + " and " + file2);
    }

    @Then("the file should be uploaded successfully and preview thumbnail should be visible")
    public void verify_upload() {

        boolean result = uploadPage.areMediaUploaded();

        if(result) {
            System.out.println("✅ Upload success and preview visible");
        } else {
            throw new AssertionError("❌ Upload failed or preview not visible");
        }
    }
}