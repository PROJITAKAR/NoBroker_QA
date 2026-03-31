package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import utils.ContextManager;
import utils.TestDataBuilder;
import utils.TokenManager;
import payloads.Booking;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteBookingTest extends BaseTest {

	@Feature("Booking API")
	@Story("Delete Booking")
	@Description("Verify that a booking can be deleted and is no longer accessible")
	@Test(dependsOnGroups = "put", groups = "delete")
    public void testDeleteBooking(ITestContext context) {

        int bookingId = ContextManager.getBookingId(context);
        Response deleteResponse = BookerEndpoints
                .deleteBooking(getRequest(), bookingId, token);

        deleteResponse.prettyPrint();

        Assert.assertEquals(deleteResponse.getStatusCode(), 201, "Delete failed");
        String deleteBody = deleteResponse.getBody().asString();
        Assert.assertNotNull(deleteBody, "Delete response body is null");
        String contentType = deleteResponse.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("text/plain") || contentType.contains("application/json"),
                "Unexpected Content-Type: " + contentType);
        Response getResponse = BookerEndpoints.getBooking(getRequest(), bookingId);
        Assert.assertEquals(getResponse.getStatusCode(), 404, "Booking still exists after delete");
        String getBody = getResponse.getBody().asString();
        Assert.assertTrue(getBody.contains("Not Found") || getBody.isEmpty(),
                "Unexpected GET response body after delete: " + getBody);
    }
}
