package pageObjects.PackersAndMoversPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================= SEARCH =================

    @FindBy(xpath = "//input[@placeholder='Search for any item']")
    private WebElement search;

    @FindBy(id = "inventory-search")
    private WebElement enterData;

    @FindBy(xpath = "//div[text()='No items found']")
    private WebElement message;

    public void searchItem() {
        search.click();
    }

    public void dataEntry(String item) {
        enterData.clear();
        enterData.sendKeys(item + Keys.ENTER);
    }
    public String getNoItemMessage() {
        return message.getText();
    }

    // ================= CATEGORY (DYNAMIC) =================

    public void selectCategory(String categoryName) {
        WebElement category = driver.findElement(
            By.xpath("//a[text()='" + categoryName + "']")
        );
        category.click();
    }

    public void selectType(String typeName) {
        WebElement type = driver.findElement(
            By.xpath("//div[text()='" + typeName + "']")
        );
        type.click();
    }

    // ================= ADD ITEM (DYNAMIC) =================

    public void addItem(String itemName) {

        WebElement item = driver.findElement(
            By.xpath("//div[text()='" + itemName + "']/parent::div/following-sibling::div")
        );

        scrollToElement(item);
        item.click();
    }

    @FindBy(xpath = "//button//div//div[text()='Continue']")
    private WebElement continueBtn;

    public void continueClick() {
        scrollToElement(continueBtn);
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

    public void increase() {
        inc.click();
    }

    // ================= COMMON UTILS =================

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}