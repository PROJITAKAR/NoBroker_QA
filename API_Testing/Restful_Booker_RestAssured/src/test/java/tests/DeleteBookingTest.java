package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import utils.AssertUtils;
import utils.TestDataBuilder;
import utils.TokenManager;
import payloads.Booking;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteBookingTest extends BaseTest {

    private int bookingId;
    private String token;

    @BeforeClass
    public void createBookingAndGetToken() {
        token = TokenManager.getToken();
        System.out.println("Token: " + token);

        Booking payload = TestDataBuilder.createBookingPayload();
        Response response = BookerEndpoints.createBooking(request, payload);
        bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Created Booking ID to delete: " + bookingId);
    }

    @Test
    public void testDeleteBooking() {
        // Step 1 - Delete the booking
        Response deleteResponse = BookerEndpoints.deleteBooking(request, bookingId, token);
        deleteResponse.prettyPrint();
        AssertUtils.verifyStatusCode(deleteResponse, 201);

        // Step 2 - Verify booking no longer exists
        Response getResponse = BookerEndpoints.getBooking(request, bookingId);
        AssertUtils.verifyStatusCode(getResponse, 404);
    }
}
