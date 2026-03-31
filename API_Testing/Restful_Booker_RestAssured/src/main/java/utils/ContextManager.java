package utils;

import org.testng.ITestContext;

public class ContextManager {

    public static void setBookingId(ITestContext context, int bookingId) {
        context.setAttribute("bookingId", bookingId);
    }

    public static int getBookingId(ITestContext context) {
        return getInt(context, "bookingId");
    }

    public static void setFirstName(ITestContext context, String firstname) {
        context.setAttribute("firstname", firstname);
    }

    public static String getFirstName(ITestContext context) {
        return getString(context, "firstname");
    }

    public static void setLastName(ITestContext context, String lastname) {
        context.setAttribute("lastname", lastname);
    }

    public static String getLastName(ITestContext context) {
        return getString(context, "lastname");
    }

    public static void setCheckin(ITestContext context, String checkin) {
        context.setAttribute("checkin", checkin);
    }

    public static String getCheckin(ITestContext context) {
        return getString(context, "checkin");
    }

    public static void setCheckout(ITestContext context, String checkout) {
        context.setAttribute("checkout", checkout);
    }

    public static String getCheckout(ITestContext context) {
        return getString(context, "checkout");
    }

    private static String getString(ITestContext context, String key) {
        Object value = context.getAttribute(key);
        if (value == null) {
            throw new RuntimeException(key + " not found in context!");
        }
        return (String) value;
    }

    private static int getInt(ITestContext context, String key) {
        Object value = context.getAttribute(key);
        if (value == null) {
            throw new RuntimeException(key + " not found in context!");
        }
        return (int) value;
    }
}