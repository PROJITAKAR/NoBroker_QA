package utils;

import payloads.Booking;
import payloads.BookingDates;

public class TestDataBuilder {

    public static Booking createBookingPayload() {

        Booking booking = new Booking();
        booking.firstname = "Projita";
        booking.lastname = "Kar";
        booking.totalprice = 1000;
        booking.depositpaid = true;

        BookingDates dates = new BookingDates();
        dates.checkin = "2024-01-01";
        dates.checkout = "2024-01-10";

        booking.bookingdates = dates;
        booking.additionalneeds = "Breakfast";

        return booking;
    }

    public static Booking updateBookingPayload() {

        Booking booking = new Booking();
        booking.firstname = "Updated";
        booking.lastname = "User";
        booking.totalprice = 2000;
        booking.depositpaid = true;

        BookingDates dates = new BookingDates();
        dates.checkin = "2024-02-01";
        dates.checkout = "2024-02-10";

        booking.bookingdates = dates;
        booking.additionalneeds = "Lunch";

        return booking;
    }
}