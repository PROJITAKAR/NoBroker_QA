package endpoints;


import constants.ApiConstants;
import payloads.Auth;
import payloads.Booking;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Booking;

public class BookerEndpoints {
	
	 public static Response createToken(RequestSpecification req, Auth authPayload) {
	        return req.body(authPayload)
	        		.when()
	                .post(ApiConstants.AUTH);
	    }

    public static Response createBooking(RequestSpecification req, Booking payload) {
        return req.body(payload)
        		.when()
                .post(ApiConstants.BOOKING);
    }

    public static Response getBooking(RequestSpecification req, int id) {
        return req
                .pathParam("id", id)
                .when()
                .get(ApiConstants.BOOKING + "/{id}");
    }

    public static Response updateBooking(RequestSpecification req, int id, Booking payload, String token) {
        return req
                .header("Cookie", "token=" + token)
                .pathParam("id", id)
                .body(payload)
                .when()
                .put(ApiConstants.BOOKING + "/{id}");
    }
    
    public static Response partialUpdateBooking(RequestSpecification req, int id, Object payload, String token) {
        return req
                .header("Cookie", "token=" + token)
                .pathParam("id", id)
                .body(payload)
                .when()
                .patch(ApiConstants.BOOKING + "/{id}");
    }

    public static Response deleteBooking(RequestSpecification req, int id, String token) {
        return req
                .header("Cookie", "token=" + token)
                .pathParam("id", id)
                .when()
                .delete(ApiConstants.BOOKING + "/{id}");
    }
    
    public static Response getBooking_allIds(RequestSpecification req) {
    	return req.when().get(ApiConstants.BOOKING);
    	
    }
    
    public static Response getBookingByName(RequestSpecification req, String firstname, String lastname) {


    	 return req
    	            .queryParam("firstname", firstname)
    	            .queryParam("lastname", lastname)
    	            .when()
    	            .get("/booking");
    }
    
    public static Response getBookingByDate(RequestSpecification req,String checkin,String checkout) {
    	return req
                .queryParam("checkin", checkin)
                .queryParam("checkout", checkout)
                .when()
                .get("/booking");
    }
    
    public static Response healthCheck(RequestSpecification req) {

        return req
                .when()
                .get(ApiConstants.PING);
    }
}