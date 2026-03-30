package endpoints;


import constants.ApiConstants;
import payloads.Auth;
import payloads.Booking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookerEndpoints {
	
	 public static Response createToken(RequestSpecification req, Auth authPayload) {
	        return req.body(authPayload)
	        		.when()
	                .post(ApiConstants.AUTH);
	    }

    public static Response createBooking(RequestSpecification req, Booking payload) {
        return req.body(payload)
        		.when()
                .post(ApiConstants.CREATE_BOOKING);
    }

    public static Response getBooking(RequestSpecification req, int id) {
        return req.when().get("/booking/" + id);
    }

    public static Response updateBooking(RequestSpecification req, int id, Booking payload, String token) {
        return req.header("Cookie", "token=" + token)
        		.when()
                .body(payload)
                .put("/booking/" + id);
    }
    
    public static Response partialUpdateBooking(RequestSpecification req, int id, Object payload, String token) {
        return req
                .header("Cookie", "token=" + token)
                .when()
                .body(payload)
                .patch("/booking/" + id);
    }

    public static Response deleteBooking(RequestSpecification req, int id, String token) {
        return req.when().header("Cookie", "token=" + token)
                .delete("/booking/" + id);
    }
}