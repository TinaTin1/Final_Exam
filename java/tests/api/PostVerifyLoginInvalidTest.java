package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginInvalidTest {

    @Test
    public void verifyLoginWithInvalidDetails() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/verifyLogin")
                .param("email", "tinn.imi.ba@gmail.com")
                .param("password", "987654321")
                .when()
                .post()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertTrue(response.asString().contains("User not found!"));
    }
}
