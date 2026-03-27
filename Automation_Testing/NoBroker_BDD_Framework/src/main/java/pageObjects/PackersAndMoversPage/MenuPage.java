package pageObjects.PackersAndMoversPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id="main-menu")
    private WebElement menu;

    @FindBy(xpath="//div[@id='main-menu']//div//a[text()='Packers and Movers']")
    private WebElement option;
    
    public void MenuClick() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }
    
    public void selectOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }}