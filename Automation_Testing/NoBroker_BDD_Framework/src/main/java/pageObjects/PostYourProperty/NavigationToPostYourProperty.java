package pageObjects.PostYourProperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationToPostYourProperty {
	
	WebDriver driver;
	
	 // Locate Elements
    @FindBy(xpath = "//div[@id='navHeader']//button")
    WebElement postPropertyBtn;

    // Constructor
    public NavigationToPostYourProperty(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   

    // Actions / Methods
    public void clickPostProperty() {
        postPropertyBtn.click();
    }
}
