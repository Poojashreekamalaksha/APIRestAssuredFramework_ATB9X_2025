package com.thetestingacademy.base;

import com.thetestingacademy.asserts.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.TokenResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification rs;
    public AssertActions asseraction;
    public PayloadManager pm;
    public JsonPath jp;
    public Response r;
    public ValidatableResponse vr;


    @BeforeTest
    public void setUp() {

        // BASE URL, Content Type JSON
        pm = new PayloadManager();
        //createPayloadBookingAsString()
        //bookingResponseJava
        asseraction = new AssertActions();
       // verifyResponsebody(String, String , String )
        //verifyResponsebody(int , int , String )
        //verifyStatusCode(Response , Integer )
        //verifyStringKey(String , String )

       rs= RestAssured
               .given()
               .baseUri(APIConstants.BASE_URL)
               .contentType(ContentType.JSON)
               .log().all();

    }

    public String getToken()
    {
        rs=RestAssured
                .given()
                .baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);
       String payload= pm.setAuthPayload();
       r=rs.contentType(ContentType.JSON).body(payload).when().post();
        String token = pm.getTokenFromJSON(r.asString());
        return token;
    }

}