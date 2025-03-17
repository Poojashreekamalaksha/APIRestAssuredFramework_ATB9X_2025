package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.*;

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

    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    // JSON to Java
    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1  = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();

    }
    public String updatefullPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Pooja");
        booking.setLastname("Shree");
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


}
