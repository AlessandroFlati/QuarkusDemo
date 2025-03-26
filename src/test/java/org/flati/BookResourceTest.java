package org.flati;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@QuarkusTest
class BookResourceTest {

    @Test
    void testGetAllBooks() {
        given()
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    void testGetBookCount() {
        given()
                .when().get("/api/books/count")
                .then()
                .statusCode(200)
                .body(not("0"));
    }

    @Test
    void testGetBookIdOne() {
        given()
                .pathParam("id", "1")
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

}