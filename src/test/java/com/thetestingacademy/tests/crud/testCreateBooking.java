package com.thetestingacademy.tests.crud;

import com.google.common.base.Verify;
import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class testCreateBooking extends BaseTest {

    @Description("Verify Post request is working fine")
    @Test(groups = "qa")
    public void testVerifyCreateBookingPOST01() {
       rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        r=RestAssured.given(rs)
                .when().body(pm.createPayloadBookingAsString()).post();
        vr=r.then().log().all();

        vr.statusCode(200);
        BookingResponse bookingResponse = pm.bookingResponseJava(r.asString());
        asseraction.verifyStringKey(bookingResponse.getBooking().getFirstname(),"James");
    }
}
