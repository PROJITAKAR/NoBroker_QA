package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPage;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        
        DriverFactory.getDriver().get("https://www.nobroker.in/");
    }

    @Before("@LoginRequired")
    public void loginSetup() throws InterruptedException {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        
        Thread.sleep(3000);
        loginPage.loginClick();
        Thread.sleep(3000);
        loginPage.loginToNoBroker("8910024596"); // replace
        Thread.sleep(30000);
        loginPage.continueClick();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}