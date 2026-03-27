package pageObjects.EPC;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeServicesPage {

    WebDriver driver;
    
    @FindBy(id = "hs_plumbing")
    WebElement EPCTile;

    @FindBy(xpath = "//div[text()='Electrician']")
    WebElement electricianTile;

    @FindBy(xpath = "//div[text()='Plumbing']")
    WebElement plumberTile;

    @FindBy(xpath = "//div[text()='Carpentry']")
    WebElement carpenterTile;
    
    @FindBy(xpath = "//div[starts-with(@id,'hs_')]")
    List<WebElement> serviceTiles;
    
    @FindBy(xpath="//div[text()='Bangalore']")
    WebElement Blr;

    public HomeServicesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void EPCTile() {
    	EPCTile.click();
    }

    public void clickElectrician() {
        electricianTile.click();
    }

    public void clickPlumber() {
        plumberTile.click();
    }

    public void clickCarpenter() {
        carpenterTile.click();
    }
    
    public void clickEPC() {
    	EPCTile.click();
    }
    
  
    
    public void selectCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement city = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='Bangalore']")
                )
            );

            city.click();
            System.out.println("City popup handled");

        } catch (TimeoutException e) {
            System.out.println("City popup not present → continuing");
        }
    }
    
    
    
    public boolean areServiceTilesVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(serviceTiles));
            return serviceTiles.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
