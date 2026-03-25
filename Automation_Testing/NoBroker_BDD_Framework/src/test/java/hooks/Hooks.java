package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import utils.DriverFactory;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() {
        
        DriverFactory.getDriver().get("https://www.nobroker.in/");
    }

    @Before("@LoginRequired")
    public void loginSetup() throws InterruptedException {

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.loginClick();
        loginPage.loginToNoBroker(""); // replace
        Thread.sleep(40000);
        loginPage.continueClick();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}