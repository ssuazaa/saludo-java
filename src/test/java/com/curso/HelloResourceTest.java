package com.curso;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class HelloResourceTest {

  @Test
  void testHelloEndpointWithQueryParam() {
    given()
        .when().get("/hello?name=Sebastian")
        .then()
        .statusCode(200)
        .body(containsString("\"name\":\"Hello Sebastian\""));
  }

  @Test
  void testHelloEndpointWithoutQueryParam() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(containsString("\"name\":\"Hello World\""));
  }

}