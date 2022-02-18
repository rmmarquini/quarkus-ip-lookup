package com.rmmarquini.iplookup.microservice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class coreTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/ip")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}