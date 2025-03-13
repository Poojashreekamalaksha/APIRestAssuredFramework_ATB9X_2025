package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingIntegrationSample {
    //create a booking, create a token
    //Verify that get booking
    //update the booking
    //delete the booking

    @Test(groups = "qa", priority = 1)
    @Description("Verify booking is created")
    @Owner("Poojashree")
    public void testCreateBooking() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Description("Verify Get Booking")
    @Owner("Poojashree")
    public void testGetBooking() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Description("Verify update booking")
    @Owner("Poojashree")
    public void testUpdateBooking() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Description("Verify delete booking")
    @Owner("Poojashree")
    public void testDeleteBooking() {
        Assert.assertTrue(true);
    }
}
