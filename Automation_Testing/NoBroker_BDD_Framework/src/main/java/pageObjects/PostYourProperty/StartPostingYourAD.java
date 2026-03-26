package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPostingYourAD {
	WebDriver driver;

	// Locate Elements
	@FindBy(xpath = "//div[@id='citySelectContainer']")
	WebElement citySelector;
	
	@FindBy(xpath = "//div[text()='Bangalore']")
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
	public void selectCity()
	{
		selectedCity.click();
	}
	public void clickStartPost()
	{
		startPost.click();
	}
	
	public boolean isCityErrorDisplayed() {
        return cityError.isDisplayed();
    }

    public String getCityErrorMessage() {
        return cityError.getText();
    }
	
}
