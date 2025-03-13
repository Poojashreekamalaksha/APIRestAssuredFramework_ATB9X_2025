package com.thetestingacademy.asserts;


import io.restassured.response.Response;


import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyResponsebody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponsebody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyStatusCode(Response response, Integer expected) {
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String keyExpect, String keyActual) {
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotNull().isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);

    }
}
