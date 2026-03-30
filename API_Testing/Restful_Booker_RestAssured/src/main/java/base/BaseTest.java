package base;

import utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {
        request = RestAssured.given()
                .baseUri(ConfigManager.get("base.url"))
                .header("Content-Type", "application/json");
    }
}