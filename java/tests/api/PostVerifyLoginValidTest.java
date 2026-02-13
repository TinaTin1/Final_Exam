package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginValidTest {

    @Test
    public void verifyLoginWithValidDetails() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/verifyLogin")
                .param("email", "21100199@ibsu.edu.ge")
                .param("password", "123456789")
                .when()
                .post()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.asString().contains("User exists!"));
    }
}
