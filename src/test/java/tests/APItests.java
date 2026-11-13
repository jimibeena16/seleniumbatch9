package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APItests {

    @Test
    public void apiTestingDemo() {

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.useRelaxedHTTPSValidation();

        //----------------------------------------------------
        // GET Request
        //----------------------------------------------------

        System.out.println("===== GET REQUEST =====");

        Response getResponse =
                given()
                    .header("Content-Type","application/json")
                .when()
                   .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        System.out.println(getResponse.asPrettyString());


        //----------------------------------------------------
        // POST Request
        //----------------------------------------------------

        System.out.println("===== POST REQUEST =====");

        String postBody = "{\n" +
                "  \"name\":\"Jimi\",\n" +
                "  \"job\":\"QA Engineer\"\n" +
                "}";

        Response postResponse =
                given()
                    .header("Content-Type","application/json")
                    .body(postBody)
                .when()
                    .post("/api/users")
                .then()
                    .statusCode(201)
                    .body("name", equalTo("Jimi"))
                    .extract()
                    .response();

        System.out.println(postResponse.asPrettyString());


        //----------------------------------------------------
        // PUT Request
        //----------------------------------------------------

        System.out.println("===== PUT REQUEST =====");

        String putBody = "{\n" +
                "  \"name\":\"Jimi Updated\",\n" +
                "  \"job\":\"Senior QA\"\n" +
                "}";
        Response puttResponse =
        given()
            .header("Content-Type","application/json")
            .body(putBody)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Jimi Updated"))
        .extract()
        .response();

        System.out.println(puttResponse.asPrettyString());
        //----------------------------------------------------
        // PATCH Request
        //----------------------------------------------------

        System.out.println("===== PATCH REQUEST =====");

        String patchBody = "{\n" +
                "  \"job\":\"Automation Lead\"\n" +
                "}";
        
        Response patchResponse =
        given()
            .header("Content-Type","application/json")
            .body(patchBody)
        .when()
            .patch("/api/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Automation Lead"))
        .extract()
        .response();

        System.out.println(patchResponse.asPrettyString());



        //----------------------------------------------------
        // DELETE Request
        //----------------------------------------------------

        System.out.println("===== DELETE REQUEST =====");

        given()
            .header("Content-Type","application/json")
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }
}