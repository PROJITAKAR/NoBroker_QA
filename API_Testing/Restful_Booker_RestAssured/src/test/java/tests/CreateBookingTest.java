package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import payloads.Booking;
import payloads.BookingDates;
import utils.ContextManager;
import utils.TestDataBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

    @Test(groups = "booking")
    public void testCreateBooking(ITestContext context) {


        Response response = BookerEndpoints.createBooking(request, TestDataBuilder.createBookingPayload());
        System.out.println(response.asPrettyString());
        int bookingId = response.path("bookingid");
        ContextManager.setBookingId(context, bookingId);


        Assert.assertEquals(response.getStatusCode(), 200);
    }
}