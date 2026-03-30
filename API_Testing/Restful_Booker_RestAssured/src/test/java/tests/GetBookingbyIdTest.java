package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import utils.AssertUtils;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBookingbyIdTest extends BaseTest {

    private int bookingId;

    @BeforeClass
    public void getValidBookingId() {
        Response response = request.get("/booking");
        bookingId = response.jsonPath().getInt("[0].bookingid");
        System.out.println("Using Booking ID: " + bookingId);
    }

    @Test
    public void testGetBookingById() {
        Response response = BookerEndpoints.getBooking(request, bookingId);
        response.prettyPrint();

        AssertUtils.verifyStatusCode(response, 200);
        AssertUtils.verifyNotNull(response.jsonPath().getString("firstname"), "firstname should not be null");
        AssertUtils.verifyNotNull(response.jsonPath().getString("lastname"), "lastname should not be null");
        AssertUtils.verifyNotNull(response.jsonPath().getString("bookingdates.checkin"), "checkin should not be null");
        AssertUtils.verifyNotNull(response.jsonPath().getString("bookingdates.checkout"), "checkout should not be null");
    }
}