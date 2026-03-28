package pageObjects.PackersAndMoversPage;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPage {

	WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//p[text()='Select City']/following-sibling::div//div//input")
    private WebElement city;
    
    @FindBy(xpath="//img[@class='rounded-100pe w-5p h-5p' and @alt='Bangalore']")
    private WebElement selectcity;
    
    @FindBy(xpath="(//span[@class='right-input-icon custom-pnm-right-icon'])[1]")
    private WebElement cancel1;
    
    @FindBy(xpath="(//span[@class='right-input-icon custom-pnm-right-icon'])[2]")
    private WebElement cancel2;
    
    @FindBy(xpath="//input[@data-index='0']")
    private WebElement pickup;
    
    @FindBy(xpath="//input[@placeholder='Shifting To']")
    private WebElement drop;
    
    @FindBy(xpath="(//div[@class='w-96pe'])[1]")
    private WebElement firstSuggestion;
    
    @FindBy(xpath="//div[text()='Where are you going to relocate?']/following-sibling::div//div[text()='Within City']")
    private WebElement type;
    
    @FindBy(id="getRealPriceButtonMobile")
    private WebElement checkPricesBtn;
    
    
    public void pickupLoc(String loc) throws InterruptedException {
    	city.click();
    	Thread.sleep(3000);
    	selectcity.click();
    	Thread.sleep(3000);
    	
    	try {
            if (cancel1.isDisplayed()) {
                cancel1.click();
            }
        } catch (Exception e) {
            // Element not present → ignore
        }

    	Thread.sleep(3000);
    	pickup.sendKeys(loc);
    	Thread.sleep(3000);
    	firstSuggestion.click();
    }
    
    public void dropLoc(String loc) throws InterruptedException {
    	try {
            if (cancel2.isDisplayed()) {
                cancel2.click();
            }
        } catch (Exception e) {
            // Element not present → ignore
        }

    	Thread.sleep(3000);
    	drop.sendKeys(loc);
    	Thread.sleep(3000);
    	firstSuggestion.click();
    }
    public void type() throws InterruptedException {
    	Thread.sleep(3000);
    	type.click();
    }
    
    public void checkPrices() throws InterruptedException {
    	Thread.sleep(3000);
    	checkPricesBtn.click();
    }
}
