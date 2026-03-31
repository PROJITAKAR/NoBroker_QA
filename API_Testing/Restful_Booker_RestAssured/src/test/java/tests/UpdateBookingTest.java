package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import payloads.Booking;
import utils.ContextManager;
import utils.TestDataBuilder;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateBookingTest extends base.BaseTest {

	@Feature("Booking API")
	@Story("Update Booking")
	@Description("Verify that all booking details can be updated successfully using PUT request")
	@Test(dependsOnGroups = "patch", groups = "put")
	public void testUpdateBooking(ITestContext context) {

		int bookingId = ContextManager.getBookingId(context);
		Booking payload = TestDataBuilder.updateBookingPayload();
		Response response = endpoints.BookerEndpoints.updateBooking(getRequest(), bookingId,
				payload, token);

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");

		String firstname = response.path("firstname");
		String lastname = response.path("lastname");
		int totalprice = response.path("totalprice");
		boolean depositpaid = response.path("depositpaid");
		String checkin = response.path("bookingdates.checkin");
		String checkout = response.path("bookingdates.checkout");
		String additionalneeds = response.path("additionalneeds");

		Assert.assertEquals(firstname, payload.firstname, "Firstname mismatch");
		Assert.assertEquals(lastname, payload.lastname, "Lastname mismatch");
		Assert.assertEquals(totalprice, payload.totalprice, "Total price mismatch");
		Assert.assertEquals(depositpaid, payload.depositpaid, "Deposit paid mismatch");
		Assert.assertEquals(checkin, payload.bookingdates.checkin, "Checkin mismatch");
		Assert.assertEquals(checkout, payload.bookingdates.checkout, "Checkout mismatch");
		Assert.assertEquals(additionalneeds, payload.additionalneeds, "Additional needs mismatch");
		Assert.assertNotNull(response.getBody(), "Response body is null");
		String contentType = response.getHeader("Content-Type");
		Assert.assertTrue(contentType.contains("application/json"), "Invalid Content-Type: " + contentType);
	}
}