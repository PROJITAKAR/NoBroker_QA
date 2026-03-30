package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import payloads.Booking;
import payloads.BookingDates;
import utils.TestDataBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

	@Test(groups = "booking")

    public void testCreateBooking() {


        Response response = BookerEndpoints.createBooking(request, TestDataBuilder.createBookingPayload());
        id = response.path("bookingid");
        //System.out.println(id);
        
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}