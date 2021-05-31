package day2;


import io.restassured.http.ContentType;
import test_util.SpartanNoAuthBaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import test_util.SpartanNoAuthBaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class VerifyingResponseInTheChain_Test extends SpartanNoAuthBaseTest {

    @DisplayName("Verifying the GET /spartans/{id} response directly in the chain")
    @Test
    public void testOneSpartanInOneShot(){


        given()
                .log().all()
                .pathParam("id",16).
        when()
                .get("/spartans/{id}").
        then()
                .statusCode(200)
                .header("Content-Type", is("application/json") )
                .contentType("application/json")
                .body("id", equalTo(16) )
                .body("name" , is("Wonder Woman") )
                .body("gender" , is("Female") )
                .body("phone" , equalTo(9234567890L))

        ;


    }

    @DisplayName("All different Logging Options")
    @Test
    public void testOneSpartanLogRequestAndResponse(){

        given()
                .log().all()
        //      .log().uri()  // just for the request url
        //      .log().body()   // for logging request body
        //      .log().params() // logging only request parameters
        //      .log().method() // just log the http method
        //      .log().ifValidationFails() // only log the request if validation in then section has failed
                .pathParam("id",16).
        when()
                .get("/spartans/{id}").
                then()
//                .log().all() // this will log the response
//                .log().body()
//                .log().ifValidationFails()
//                .log().status()
//                .log().headers()
//                .log().ifError() // anything not 2xx status is seen as error for this method
//                .log().ifStatusCodeIsEqualTo(200)
                .statusCode(200) ;

    }



}
