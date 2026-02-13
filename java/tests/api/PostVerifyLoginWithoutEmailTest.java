package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginWithoutEmailTest {

    @Test
    public void verifyLoginWithoutEmail() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/verifyLogin")
                .param("password", "123456789")
                .when()
                .post()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(response.asString().contains("Bad request, email or password parameter is missing in POST request"));
    }
}
