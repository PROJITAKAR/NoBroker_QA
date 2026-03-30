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

    @Test
    public void testCreateBooking() {


        Response response = BookerEndpoints.createBooking(request, TestDataBuilder.createBookingPayload());
        id = response.path("bookingid");
        //System.out.println(id);
        
        firstname = response.path("booking.firstname");
        lastname = response.path("booking.lastname");
        checkin = response.path("booking.bookingdates.checkin");
        checkout = response.path("booking.bookingdates.checkout");
        
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}