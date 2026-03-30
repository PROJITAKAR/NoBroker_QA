package pageObjects.SearchFilterPageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class PGresultsPage {

    WebDriver driver;
    WebDriverWait wait;

    public PGresultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "resetButton")
    WebElement resetButton;

    @FindBy(xpath = "//div[@type=\"button\"]")
    WebElement Chatbot_button;
    
    @FindBy(xpath = "//textarea[@placeholder='Type a message...']")
    WebElement Chatbot_msg;
    
    @FindBy(xpath = "//button[.//img[@alt='send'] and not(@disabled)]")
    WebElement chatbot_send_btn;

    @FindBy(id = "pg_boys")
    WebElement boys;

    @FindBy(id = "sharing_single")
    WebElement single;

    @FindBy(id = "sharing_double")
    WebElement doubleRoom;

    @FindBy(id = "prefence_student")
    WebElement student;

    @FindBy(id = "food_lunch")
    WebElement lunch;

    @FindBy(xpath = "//div[text()='With Photos']")
    WebElement photos;


    By results = By.xpath("//div[contains(@class,'infinite-scroll-component')]//article");


    public void safeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }



    public void handleMetroPopup() {
        try {
            List<WebElement> skip = driver.findElements(
                    By.xpath("//span[contains(text(),'Skip')]")
            );

            if (!skip.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(skip.get(0))).click();
            }
        } catch (Exception e) {
            
        }
    }
    
    public void click_start_chat() {

        WebElement chatBtn = wait.until(
            ExpectedConditions.visibilityOf(Chatbot_button)
        );

        wait.until(ExpectedConditions.elementToBeClickable(chatBtn));
        chatBtn.click();

        wait.until(ExpectedConditions.visibilityOf(Chatbot_msg));
    }
    
    public void enterChatMessage(String message) throws InterruptedException {

        WebElement msgBox = wait.until(
            ExpectedConditions.visibilityOf(Chatbot_msg)
        );
        msgBox.click();
        Thread.sleep(1000);
        msgBox.sendKeys(message);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void clickSendButton() {
    	WebElement sendButton = wait.until(ExpectedConditions.visibilityOf(chatbot_send_btn));
    	sendButton.click();
    }
    
    public boolean isMessageDisplayed() {
        return driver.getPageSource().contains("Hello");
    }
    
    
    public void resetFilters() {
    	handleMetroPopup();
    	//Thread.sleep(3000);
        safeClick(resetButton);
    }

    public void applyPGFilters() {
        safeClick(boys);
        safeClick(single);
        safeClick(doubleRoom);
        safeClick(student);
        safeClick(lunch);
        safeClick(photos);
    }

    public void clickFirstProperty() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(results)
        );

        if (!list.isEmpty()) {
            list.get(0).click();
        } else {
            throw new RuntimeException("No PG properties found");
        }
    }
}