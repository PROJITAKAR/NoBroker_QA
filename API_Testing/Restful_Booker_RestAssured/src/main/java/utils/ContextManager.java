package utils;

import org.testng.ITestContext;

public class ContextManager {

    public static void setBookingId(ITestContext context, int bookingId) {
        context.setAttribute("bookingId", bookingId);
    }

    public static int getBookingId(ITestContext context) {

        Object id = context.getAttribute("bookingId");

        if (id == null) {
            throw new RuntimeException("Booking ID not found in context!");
        }

        return (int) id;
    }
}