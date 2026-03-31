package base;

import utils.ConfigManager;
import utils.CustomHtmlReporter;
import utils.TokenManager;
import utils.TokenManager;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({CustomHtmlReporter.class})
public class BaseTest {

    protected static String token;

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        token = TokenManager.getToken();
    }

    protected RequestSpecification getRequest() {
        return RestAssured.given()
                .baseUri(ConfigManager.get("base.url"))
                .header("Content-Type", "application/json");
    }
}