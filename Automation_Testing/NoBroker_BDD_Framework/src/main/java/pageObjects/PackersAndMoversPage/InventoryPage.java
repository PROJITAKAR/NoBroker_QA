package pageObjects.PackersAndMoversPage;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= SEARCH =================
    
    @FindBy(xpath="//img[@alt='close']")
    private WebElement close;

    @FindBy(xpath = "//input[@placeholder='Search for any item']")
    private WebElement search;

    @FindBy(id = "inventory-search")
    private WebElement enterData;

    @FindBy(xpath = "//div[text()='No items found']")
    private WebElement message;

    public void searchItem() throws InterruptedException {
    	Thread.sleep(3000);
    	try {
            if (close.isDisplayed()) {
                close.click();
            }
        } catch (Exception e) {
            // close not present → ignore
        }

    	Thread.sleep(3000);
        search.click();
    }

    public void dataEntry(String item) throws InterruptedException {
    	Thread.sleep(3000);
        enterData.clear();
        Thread.sleep(3000);
        enterData.sendKeys(item + Keys.ENTER);
    }
    public String getNoItemMessage() throws InterruptedException {
    	Thread.sleep(3000);
        return message.getText();
    }

    // ================= CATEGORY (DYNAMIC) =================

    public void selectCategory(String categoryName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Click the category tab in the horizontal scroll bar
        WebElement categoryTab = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'flex-shrink-0')]//a[text()='" + categoryName + "']")
        ));
        js.executeScript("arguments[0].click();", categoryTab);
        Thread.sleep(2000);
        
        // Find the accordion section header - using the parent div structure from HTML
        // The header div contains a div with the text inside flex items-center justify-between
        WebElement sectionHeader = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class,'flex') and contains(@class,'items-center') " +
                     "and contains(@class,'justify-between')]" +
                     "/div[text()='" + categoryName + "']")
        ));
        
        // Scroll to section
        js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -150);", sectionHeader);
        Thread.sleep(1000);
        
        // Check if accordion is collapsed by looking for open-accordian image in parent
        WebElement accordionParent = sectionHeader.findElement(
            By.xpath("./ancestor::div[contains(@class,'border-gray-300')]")
        );
        
        boolean isCollapsed = !accordionParent.findElements(
            By.xpath(".//img[contains(@src,'open-accordian')]")
        ).isEmpty();
        
        if (isCollapsed) {
            js.executeScript("arguments[0].click();", sectionHeader);
            Thread.sleep(1500);
        }
    }

    public void selectType(String typeName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        Thread.sleep(2000);
        
        // Target item text inside accordion content area
        // Based on HTML: div.py-3 > div.flex > div.flex > div.font-normal with item name
        WebElement type = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[contains(@class,'py-3')]" +
                     "//div[contains(@class,'font-normal') " +
                     "and contains(@class,'text-14') " +
                     "and text()='" + typeName + "']")
        ));
        
        // Scroll into view with offset for sticky header
        js.executeScript(
            "arguments[0].scrollIntoView(true); window.scrollBy(0, -150);", 
            type
        );
        Thread.sleep(1000);
        
        // Click the parent py-3 div (the clickable row)
        WebElement clickableRow = type.findElement(
            By.xpath("./ancestor::div[contains(@class,'py-3')]")
        );
        js.executeScript("arguments[0].click();", clickableRow);
        
        Thread.sleep(1000);
    }    
    // ================= ADD ITEM (DYNAMIC) =================

    public void addItem(String itemName) throws InterruptedException {

    	Thread.sleep(3000);
        WebElement item = driver.findElement(
            By.xpath("//div[text()='" + itemName + "']/parent::div/following-sibling::div")
        );

        Thread.sleep(3000);
     //   scrollToElement(item);
        item.click();
    }

    @FindBy(xpath = "//button//div//div[text()='Continue']")
    private WebElement continueBtn;

    public void continueClick() throws InterruptedException {
    	Thread.sleep(3000);
        scrollToElement(continueBtn);
        Thread.sleep(3000);
        continueBtn.click();
    }

    // ================= UPDATE ITEM =================

    @FindBy(id = "decreament")
    private WebElement dec;

    @FindBy(id = "increament")
    private WebElement inc;

    public void decrease() {
        dec.click();
    }

    public void increaseItem(String itemName) {

        try {
            // Locate "+" button ONLY if item is already added
            WebElement increaseBtn = driver.findElement(
                By.xpath("//div[text()='"+ itemName +"']/parent::div/following-sibling::div//div//div[@id='increament']")
            );

            if (increaseBtn.isDisplayed()) {
                System.out.println("✅ Item already present. Increasing quantity: " + itemName);
                increaseBtn.click();
            }

        } catch (NoSuchElementException e) {
            System.out.println("⚠️ Item not added yet. Skipping increase: " + itemName);
        }
    }

    // ================= COMMON UTILS =================

    public void scrollToElement(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}