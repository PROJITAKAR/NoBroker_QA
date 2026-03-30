package utils;

import payloads.Auth;
import constants.ApiConstants;
import endpoints.BookerEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenManager {

    public static String getToken() {

        Auth auth = new Auth();
        auth.username = ConfigManager.get("username");
        auth.password = ConfigManager.get("password");

        RequestSpecification request = RestAssured.given()
                .baseUri(ConfigManager.get("base.url"))
                .header("Content-Type", "application/json");

        Response response = BookerEndpoints.createToken(request, auth);

        response.then().log().all();

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Token generation failed! Status: " + response.getStatusCode());
        }

        String contentType = response.getHeader("Content-Type");
        if (contentType == null || !contentType.contains("application/json")) {
            throw new RuntimeException("Invalid Content-Type: " + contentType);
        }

        String token = response.jsonPath().getString("token");
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Token is null or empty!");
        }

        return token;
    }
}