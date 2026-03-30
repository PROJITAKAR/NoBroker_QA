package stepDefinitions.postYourProperty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import pageObjects.PostYourProperty.UploadMediaPage;
import utils.DriverFactory;
import utils.ExcelUtil;

public class SC04_UploadSteps {

	WebDriver driver = DriverFactory.getDriver();
	UploadMediaPage uploadPage = new UploadMediaPage(driver);
	Map<String, String> data;

	@Given("the user loads photo upload test data {string} from sheet {string}")
	public void the_user_loads_photo_upload_test_data_from_sheet(String tcId, String sheetName) {
		data = ExcelUtil.getTestData("PostYourProperty", sheetName, tcId);
	}

	@When("the user uploads photo and video from test data")
	public void the_user_uploads_photo_and_video_from_test_data() throws InterruptedException {
		String file1 = data.get("file1"); // image
		String file2 = data.get("file2"); // video

		String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testfiles\\images\\" + file1;
	    String videoPath = System.getProperty("user.dir") + "\\src\\test\\resources\\testfiles\\videos\\" + file2;

		uploadPage.uploadImage(imagePath);
		Thread.sleep(2000);

		uploadPage.uploadVideo(videoPath);
		Thread.sleep(3000);

		System.out.println("Uploaded: " + file1 + " and " + file2);
	}

	@Then("the file should be uploaded successfully and preview thumbnail should be visible")
	public void verify_upload() {

		boolean result = uploadPage.areMediaUploaded();

		if (result) {
			System.out.println("✅ Upload success and preview visible");
		} else {
			throw new AssertionError("❌ Upload failed or preview not visible");
		}
	}
}