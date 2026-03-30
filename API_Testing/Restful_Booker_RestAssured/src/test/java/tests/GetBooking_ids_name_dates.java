package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.TestDataBuilder;

public class GetBooking_ids_name_dates extends BaseTest {
	
    @Test
    public void testGetBookingAllIds() {


        Response response = BookerEndpoints.getBooking_allIds(request);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    @Test
    public void testGetBookingByName() {
  
        Response response = BookerEndpoints.getBookingByName(request,firstname,lastname);
        System.out.println(response.asPrettyString());
        
        Assert.assertEquals(response.getStatusCode(), 200);
    
    }
    @Test
    public void testGetBookingByDate() {
    	Response response = BookerEndpoints.getBookingByDate(request, checkin, checkout);
        System.out.println(response.asPrettyString());
        
        Assert.assertEquals(response.getStatusCode(), 200);

    }

}
