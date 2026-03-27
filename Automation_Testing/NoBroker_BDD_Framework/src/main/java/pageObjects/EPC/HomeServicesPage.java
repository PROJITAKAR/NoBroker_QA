package pageObjects.EPC;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
