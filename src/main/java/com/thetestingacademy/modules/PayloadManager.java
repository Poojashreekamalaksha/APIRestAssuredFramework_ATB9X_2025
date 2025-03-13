package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingDates;
import com.thetestingacademy.pojos.BookingResponse;

public class PayloadManager {
    Gson gson;

    //converting JAVA Object to String
    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        System.out.println(booking);

        gson = new Gson();
        String payload = gson.toJson(booking);
        System.out.println(payload);
        return payload;
        //Converting String to JAVA Object
    }
        public BookingResponse bookingResponseJava(String responstring) {
            gson = new Gson();
            BookingResponse bookingResponse = gson.fromJson(responstring, BookingResponse.class);
            return bookingResponse;
        }
    }
