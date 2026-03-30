package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HealthCheck extends BaseTest {

    @Test
    public void healthCheck() {

        Response response = BookerEndpoints.healthCheck(request);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}