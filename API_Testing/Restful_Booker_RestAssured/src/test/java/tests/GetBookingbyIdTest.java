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
import utils.ContextManager;

public class GetBookingbyIdTest extends BaseTest {
	
	@Feature("Booking API")
	@Story("Get Booking by ID")
	@Description("Verify that booking details can be retrieved using a valid booking ID")
	@Test(dependsOnGroups = "booking", groups = "getByid")
    public void testGetBookingById(ITestContext context) {

        int bookingId = ContextManager.getBookingId(context);
        Response response = BookerEndpoints.getBooking(getRequest(), bookingId);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");
        String firstname = response.path("firstname");
        String lastname = response.path("lastname");
        String checkin = response.path("bookingdates.checkin");
        String checkout = response.path("bookingdates.checkout");

        Assert.assertNotNull(firstname, "Firstname is null");
        Assert.assertNotNull(lastname, "Lastname is null");
        Assert.assertNotNull(checkin, "Checkin is null");
        Assert.assertNotNull(checkout, "Checkout is null");
        Assert.assertEquals(firstname, ContextManager.getFirstName(context), "Firstname mismatch");
        Assert.assertEquals(lastname, ContextManager.getLastName(context), "Lastname mismatch");
        Assert.assertEquals(checkin, ContextManager.getCheckin(context), "Checkin mismatch");
        Assert.assertEquals(checkout, ContextManager.getCheckout(context), "Checkout mismatch");
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"),
                "Invalid Content-Type: " + contentType);
       
    }
}