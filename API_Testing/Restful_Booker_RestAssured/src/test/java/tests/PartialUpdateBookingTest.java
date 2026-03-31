package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import payloads.PartialBooking;
import utils.ContextManager;
import utils.TestDataBuilder;

public class PartialUpdateBookingTest extends BaseTest {

	@Feature("Booking API")
	@Story("Partial Update Booking")
	@Description("Verify that selected booking fields can be updated using PATCH request")
	@Test(dependsOnGroups = "filter", groups = "patch")
	public void testPartialUpdateBooking(ITestContext context) {

		int bookingId = ContextManager.getBookingId(context);
		PartialBooking payload = TestDataBuilder.partialUpdatePayload();

		Response response = BookerEndpoints.partialUpdateBooking(getRequest(), bookingId, payload, token);

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");
		String actualFirstName = response.path("firstname");
		String actualLastName = response.path("lastname");
		Assert.assertEquals(actualFirstName, payload.firstname, "Firstname not updated correctly");
		Assert.assertEquals(actualLastName, payload.lastname, "Lastname not updated correctly");
		String actualCheckin = response.path("bookingdates.checkin");
		String actualCheckout = response.path("bookingdates.checkout");
		Assert.assertEquals(actualCheckin, ContextManager.getCheckin(context), "Checkin should not change");
		Assert.assertEquals(actualCheckout, ContextManager.getCheckout(context), "Checkout should not change");
		Assert.assertNotNull(response.getBody(), "Response body is null");
		String contentType = response.getHeader("Content-Type");
		Assert.assertTrue(contentType.contains("application/json"), "Invalid Content-Type: " + contentType);

	}
}