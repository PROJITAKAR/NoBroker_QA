package endpoints;


import constants.ApiConstants;
import payloads.Booking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookerEndpoints {

    public static Response createBooking(RequestSpecification req, Booking payload) {
        return req.body(payload)
                .post(ApiConstants.CREATE_BOOKING);
    }

    public static Response getBooking(RequestSpecification req, int id) {
        return req.get("/booking/" + id);
    }

    public static Response updateBooking(RequestSpecification req, int id, Booking payload, String token) {
        return req.header("Cookie", "token=" + token)
                .body(payload)
                .put("/booking/" + id);
    }

    public static Response deleteBooking(RequestSpecification req, int id, String token) {
        return req.header("Cookie", "token=" + token)
                .delete("/booking/" + id);
    }
}