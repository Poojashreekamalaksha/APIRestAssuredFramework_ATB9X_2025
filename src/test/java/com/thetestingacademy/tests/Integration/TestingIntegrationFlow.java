package com.thetestingacademy.tests.Integration;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestingIntegrationFlow extends BaseTest {


    @Test(groups = "qa", priority = 1)
    @Owner("Poojashree")
    @Description("Verify booking is created")
    public void testCreateBooking(ITestContext iTestContext) {

        rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        r = RestAssured.given(rs)
                .when().body(pm.createPayloadBookingAsString()).post();
        vr = r.then().log().all();

        vr.statusCode(200);
        BookingResponse bookingResponse = pm.bookingResponseJava(r.asString());
        asseraction.verifyStringKey(bookingResponse.getBooking().getFirstname(), "James");
        System.out.println(bookingResponse.getBookingid());
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());
    }

    @Test(groups = "qa", priority = 2)
    @Description("Verify Get Booking")
    @Owner("Poojashree")
    public void testVerifyBookingId(ITestContext iTestContext) {
        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGet);
        rs.basePath(basePathGet);
        r = RestAssured.given(rs).when().get();
        vr = r.then().log().all();
        vr.statusCode(200);

        Booking booking=pm.getResponseFromJSON(r.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("James");
    }

    @Test(groups = "qa", priority = 3)
    @Description("Verify update booking")
    @Owner("Poojashree")
    public void testUpdateBooking(ITestContext iTestContext) {
        System.out.println("Token API Response: " + r.asString());
        System.out.println("Auth API URL: " + APIConstants.BASE_URL + APIConstants.AUTH_URL);
        System.out.println(iTestContext.getAttribute("bookingid"));

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();
        iTestContext.setAttribute("token",token);

        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPUTPATCH);

        rs.basePath(basePathPUTPATCH);

        r = RestAssured
                .given(rs).cookie("token", token)
                .when().body(pm.updatefullPayloadBookingAsString()).put();


        vr = r.then().log().all();
        // Validatable Assertion
        vr.statusCode(200);

        Booking booking = pm.getResponseFromJSON(r.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Pooja");
        assertThat(booking.getLastname()).isEqualTo("Shree");



    }

    @Test(groups = "qa", priority = 4)
    @Description("Verify delete booking")
    @Owner("Poojashree")
    public void testDeleteBooking(ITestContext iTestContext) {

        System.out.println(iTestContext.getAttribute("bookingid"));

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();
        iTestContext.setAttribute("token",token);

        String basePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathDelete);

        rs.basePath(basePathDelete);

        r = RestAssured
                .given(rs).cookie("token", token)
                .when().delete();


        vr = r.then().log().all();
        // Validatable Assertion
        vr.statusCode(201);

       /*Booking booking = pm.getResponseFromJSON(r.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Pooja");
        assertThat(booking.getLastname()).isEqualTo("Shree");*/



    }
    @Test(groups = "qa", priority = 5)
    @Description("Verify  bookingId after delete")
    @Owner("Poojashree")
    public void testVerifyDeleteBooking(ITestContext iTestContext) {

        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathGet = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGet);
        rs.basePath(basePathGet);
        r = RestAssured.given(rs).when().get();
        vr = r.then().log().all();
        vr.statusCode(404);



    }
}


