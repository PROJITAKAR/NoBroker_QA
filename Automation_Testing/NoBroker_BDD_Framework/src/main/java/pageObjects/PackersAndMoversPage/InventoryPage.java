package pageObjects.PackersAndMoversPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Search an item and add
    @FindBy(xpath="//input[@placeholder='Search for any item']")
    private WebElement search;
    
    @FindBy(id="inventory-search")
    private WebElement enterData;
    
    @FindBy(xpath="//div[text()='No items found']")
    private WebElement message;
    
    public void searchItem() {
    	search.click();
    }
    
    public void dataEntry(String item) {
    	enterData.sendKeys(item+Keys.ENTER);
    }
    
    public String getNoItemMessage() {
        return message.getText();
    }
    
    
    //add an item via category
    @FindBy(xpath="//a[text()='Bedrooms']")
    private WebElement category;
    
    @FindBy(xpath="//div[@id='67d84a4ae50df484e137daeb']//div[text()='Bed']")
    private WebElement type;
    
    @FindBy(xpath="//div[text()='King Size Bed - With Storage']/parent::div/following-sibling::div")
    private WebElement add;
    
    @FindBy(xpath="//button//div//div[text()='Continue']")
    private WebElement continueBtn;
    
    public void sectionSelect() {
    	category.click();
    }
    
    public void selectType() {
    	type.click();
    }
    
    public void addItem() {
    	add.click();
    }
    
    public void continueClick() {
    	continueBtn.click();
    }
    
    //Update Item
    @FindBy(id="decreament")
    private WebElement dec;
    
    @FindBy(id="increament")
    private WebElement inc;
    
    public void decrease() {
    	dec.click();
    }
    
    public void increase() {
    	inc.click();
    }
}
