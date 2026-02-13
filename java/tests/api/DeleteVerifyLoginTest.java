package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteVerifyLoginTest {

    @Test
    public void deleteVerifyLoginShouldReturn405() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/verifyLogin")
                .when()
                .delete()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 405);
        Assert.assertTrue(response.asString().contains("This request method is not supported"));
    }
}
