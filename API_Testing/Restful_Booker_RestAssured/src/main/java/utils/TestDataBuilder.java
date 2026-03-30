package utils;

import payloads.Booking;
import payloads.BookingDates;
import payloads.PartialBooking;

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
        booking.firstname = "James";
        booking.lastname = "Brown";
        booking.totalprice = 111;
        booking.depositpaid = true;
        
        BookingDates dates = new BookingDates();
        dates.checkin = "2018-01-01";
        dates.checkout = "2019-01-01";

        booking.bookingdates = dates;
        booking.additionalneeds = "Breakfast";

        return booking;
    }
    
    
    public static PartialBooking partialUpdatePayload() {

        PartialBooking booking = new PartialBooking();

        booking.firstname = "James";
        booking.lastname = "Brown";

        return booking;
    }
}