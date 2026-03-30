package utils;

import payloads.Auth;
import io.restassured.RestAssured;

public class TokenManager {

    public static String getToken() {

        Auth auth = new Auth();
        auth.username = ConfigManager.get("username");
        auth.password = ConfigManager.get("password");

        return RestAssured.given()
                .baseUri(ConfigManager.get("base.url"))
                .header("Content-Type", "application/json")
                .body(auth)
                .post("/auth")
                .jsonPath()
                .getString("token");
    }
}