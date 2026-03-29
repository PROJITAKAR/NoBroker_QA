package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPostingYourAD {
	WebDriver driver;

	// Locate Elements
	@FindBy(xpath = "//div[@id='citySelectContainer']")
	WebElement citySelector;
	
	@FindBy(xpath = "//div[text()='Pune']")
	WebElement selectedCity;
	
	@FindBy(xpath = "//div[@id='citySelectContainer']/../../../following-sibling::div//button")
	WebElement startPost;
	
	@FindBy(xpath = "//span[contains(text(),'Please select a valid city')]")
    WebElement cityError;
	
	public StartPostingYourAD(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCityDropDown()
	{
		citySelector.click();
	}
	public void selectCity() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    By cityLocator = By.xpath("//div[text()='Pune']");

	    WebElement city = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(cityLocator)
	    );

	    city.click();
	}
	public void clickStartPost()
	{
		startPost.click();
	}
	
	public void goToPropertyDetailsPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Click dropdown
	    wait.until(ExpectedConditions.elementToBeClickable(citySelector)).click();

	    // WAIT for city options
	    By cityLocator = By.xpath("//div[text()='Pune']");
	    WebElement city = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(cityLocator)
	    );

	    city.click();

	    // Click Start Post
	    wait.until(ExpectedConditions.elementToBeClickable(startPost)).click();

	    System.out.println("✅ Navigated to Property Details Page");
	}
	
	public boolean isCityErrorDisplayed() {
        return cityError.isDisplayed();
    }

    public String getCityErrorMessage() {
        return cityError.getText();
    }
	
}
