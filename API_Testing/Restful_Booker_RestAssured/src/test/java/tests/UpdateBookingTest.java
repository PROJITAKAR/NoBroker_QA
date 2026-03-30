package tests;

import io.restassured.response.Response;
import utils.TestDataBuilder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateBookingTest extends base.BaseTest {

	@Test(dependsOnGroups = "booking")
	public void testUpdateBooking() {
		
        Response response = endpoints.BookerEndpoints.updateBooking(request, id, TestDataBuilder.updateBookingPayload(), token);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}