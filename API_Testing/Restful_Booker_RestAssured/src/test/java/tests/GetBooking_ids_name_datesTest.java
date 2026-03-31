package tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import utils.ContextManager;

public class GetBooking_ids_name_datesTest extends BaseTest {
	
	@Feature("Booking API")
	@Story("Get All Booking IDs")
	@Description("Verify that all booking IDs are returned and response structure is valid")
	@Test(dependsOnGroups = "getByid", groups = "filter", priority = 0)
    public void testGetBookingAllIds() {

        Response response = BookerEndpoints.getBooking_allIds(getRequest());
        
        System.out.println(response.asPrettyString());


        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");

        List<Map<String, Object>> bookings = response.jsonPath().getList("$");

        Assert.assertTrue(bookings.size() > 0, "Booking list is empty");

        for (Map<String, Object> booking : bookings) {
            Assert.assertTrue(booking.containsKey("bookingid"), "Missing bookingid");

            int id = (int) booking.get("bookingid");
            Assert.assertTrue(id > 0, "Invalid bookingid");
        }

        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"),
                "Invalid Content-Type: " + contentType);
    }

	@Feature("Booking API")
	@Story("Filter Booking by Name")
	@Description("Verify that bookings can be filtered using firstname and lastname query parameters")
	@Test(dependsOnGroups = "getByid", groups = "filter", priority = 1)
    public void testGetBookingByName(ITestContext context) {

        String firstname = ContextManager.getFirstName(context);
        String lastname = ContextManager.getLastName(context);

        Response response = BookerEndpoints
                .getBookingByName(getRequest(), firstname, lastname);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        List<Map<String, Object>> bookings = response.jsonPath().getList("$");

        Assert.assertNotNull(bookings, "Response list is null");

        for (Map<String, Object> booking : bookings) {
            Assert.assertTrue(booking.containsKey("bookingid"), "Missing bookingid");

            int id = (int) booking.get("bookingid");
            Assert.assertTrue(id > 0, "Invalid bookingid");
        }
    }

	@Feature("Booking API")
	@Story("Filter Booking by Date")
	@Description("Verify that bookings can be filtered using check-in and check-out dates")
	@Test(dependsOnGroups = "getByid", groups = "filter",priority = 2)
    public void testGetBookingByDate(ITestContext context) {

        String checkin = ContextManager.getCheckin(context);
        String checkout = ContextManager.getCheckout(context);

        Response response = BookerEndpoints
                .getBookingByDate(getRequest(), checkin, checkout);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);

        List<Map<String, Object>> bookings = response.jsonPath().getList("$");

        Assert.assertNotNull(bookings, "Response list is null");

        for (Map<String, Object> booking : bookings) {
            Assert.assertTrue(booking.containsKey("bookingid"), "Missing bookingid");

            int id = (int) booking.get("bookingid");
            Assert.assertTrue(id > 0, "Invalid bookingid");
        }
    }
}