package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;

public class ApiTests {
    @Test
    public void simpleTest() {
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .baseUri("https://petstore.swagger.io/v2/")
                .when()
                    .body(body)
                    .post("user")
                .andReturn();

        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void simpleApiTest() {
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                .baseUri("https://petstore.swagger.io/v2/")
                .contentType("application/json")
                .accept("application/json")
                .body(body)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
