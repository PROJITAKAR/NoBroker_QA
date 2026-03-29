package pageObjects.PostYourProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostYourPropertyMainPage {
    
    WebDriver driver;

    // Locate Elements
    @FindBy(xpath = "//button[@id='postNow']")
    WebElement postNowBtn;

    // Constructor
    public PostYourPropertyMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPostNow() throws InterruptedException {
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        try {
            WebElement postNowBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("postNow"))
            );
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", postNowBtn);
            Thread.sleep(500);
            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", postNowBtn);
            System.out.println("✅ Clicked postNow button");

        } catch (Exception e) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='citySelectContainer']")
                    )
                );
                System.out.println("✅ Rare case — already on Start Posting AD section, skipping postNow");
            } catch (Exception ex) {
                throw new RuntimeException("❌ postNow failed and not on Start AD page. URL: "
                    + driver.getCurrentUrl());
            }
        }
    }
}