package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertUtils {

    // Status Code Assertion
    public static void verifyStatusCode(Response response, int expectedStatus) {
        Assert.assertEquals(
                response.getStatusCode(),
                expectedStatus,
                "Status code mismatch!"
        );
    }

    // Response Body Key Assertion
    public static void verifyResponseField(Response response, String key, String expectedValue) {
        String actualValue = response.jsonPath().getString(key);

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Mismatch in field: " + key
        );
    }

    // Integer Field Assertion
    public static void verifyResponseField(Response response, String key, int expectedValue) {
        int actualValue = response.jsonPath().getInt(key);

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Mismatch in field: " + key
        );
    }

    // Boolean Field Assertion
    public static void verifyResponseField(Response response, String key, boolean expectedValue) {
        boolean actualValue = response.jsonPath().getBoolean(key);

        Assert.assertEquals(
                actualValue,
                expectedValue,
                "Mismatch in field: " + key
        );
    }

    // Header Assertion
    public static void verifyHeader(Response response, String headerName, String expectedValue) {
        String actualHeader = response.getHeader(headerName);

        Assert.assertEquals(
                actualHeader,
                expectedValue,
                "Header mismatch: " + headerName
        );
    }

    // Not Null Assertion
    public static void verifyNotNull(Object obj, String message) {
        Assert.assertNotNull(obj, message);
    }
}