package pageObjects.PostYourProperty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationToPostYourProperty {
    
    WebDriver driver;
    
    // Locate Elements
    @FindBy(id = "main-menu")
    WebElement menu;
    
    @FindBy(xpath="//div[@id='main-menu']//div//a[text()='Post Your Property']")
    WebElement postPropertyBtn;

    // Constructor
    public NavigationToPostYourProperty(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions / Methods
    public void clickPostProperty() {
        
        try {
            menu.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", menu);
        }

        try {
            postPropertyBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", postPropertyBtn);
        }
    }
}