package tests;

import base.BaseTest;
import endpoints.BookerEndpoints;
import io.restassured.response.Response;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import payloads.PartialBooking;
import utils.AssertUtils;
import utils.ContextManager;
import utils.TestDataBuilder;

public class PartialUpdateBookingTest extends BaseTest {

    @Test(dependsOnGroups = "booking")
    public void testPartialUpdateBooking(ITestContext context) {
    	int bookingId = ContextManager.getBookingId(context);

        PartialBooking payload = TestDataBuilder.partialUpdatePayload();

        Response response = BookerEndpoints
                .partialUpdateBooking(request, bookingId, payload, token);

        System.out.println(response.asPrettyString());

        AssertUtils.verifyStatusCode(response, 200);
        AssertUtils.verifyResponseField(response, "firstname", "James");
        AssertUtils.verifyResponseField(response, "lastname", "Brown");
    }
}