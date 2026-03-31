package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCheckTest extends BaseTest {
	
	@Feature("Booking API")
	@Story("Health Check")
	@Description("Verify that the Booking API service is up and running")
	@Test(groups = "health")
	public void healthCheck() {

		Response response = BookerEndpoints.healthCheck(getRequest());

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch");


		String contentType = response.getHeader("Content-Type");
		Assert.assertTrue(contentType.contains("text/plain") || contentType.contains("application/json"),
				"Unexpected Content-Type: " + contentType);

		String body = response.getBody().asString();
		Assert.assertNotNull(body, "Response body is null");

		Assert.assertTrue(body.contains("Created") || body.isEmpty(), "Unexpected response body: " + body);
	}
}