package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import payloads.Booking;
import payloads.BookingDates;
import utils.ContextManager;
import utils.TestDataBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

	@Feature("Booking API")
	@Story("Create Booking")
	@Description("Verify that a new booking can be created successfully and returns a valid booking ID")
	@Test(dependsOnGroups ="health", groups = "booking")
    public void testCreateBooking(ITestContext context) {


        Response response = BookerEndpoints.createBooking(getRequest(), TestDataBuilder.createBookingPayload());
        int bookingId = response.path("bookingid");
        String firstname = response.path("booking.firstname");
        String lastname = response.path("booking.lastname");
        String checkin = response.path("booking.bookingdates.checkin");
        String checkout = response.path("booking.bookingdates.checkout");

        ContextManager.setBookingId(context, bookingId);
        ContextManager.setFirstName(context, firstname);
        ContextManager.setLastName(context, lastname);
        ContextManager.setCheckin(context, checkin);
        ContextManager.setCheckout(context, checkout);
                
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");
        Assert.assertTrue(bookingId > 0, "Invalid booking ID");
        Assert.assertEquals(firstname, "John", "Firstname mismatch");
        Assert.assertEquals(lastname, "Doe", "Lastname mismatch");
        Assert.assertNotNull(checkin, "Checkin date is null");
        Assert.assertNotNull(checkout, "Checkout date is null");
        Assert.assertTrue(checkin.matches("\\d{4}-\\d{2}-\\d{2}"), "Invalid checkin format");
        Assert.assertTrue(checkout.matches("\\d{4}-\\d{2}-\\d{2}"), "Invalid checkout format");

    }
}