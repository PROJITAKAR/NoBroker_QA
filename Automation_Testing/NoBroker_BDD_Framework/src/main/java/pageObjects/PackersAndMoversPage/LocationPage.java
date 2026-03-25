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
    
    
    public void pickupLoc(String loc) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancel1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pickup)).click();

        pickup.sendKeys(loc);

        wait.until(ExpectedConditions.visibilityOf(firstSuggestion)).click();
    }
    
    public void dropLoc(String loc) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(cancel2)).click();

    	    wait.until(ExpectedConditions.elementToBeClickable(drop)).click();
    	    drop.sendKeys(loc+ Keys.ENTER);

    	    wait.until(ExpectedConditions.visibilityOf(firstSuggestion)).click();
    	}
    
    public void type() {
    	type.click();
    }
    
    public void checkPrices() {
    	checkPricesBtn.click();
    }
}
