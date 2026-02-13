package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostSearchProductWithoutParamTest {

    @Test
    public void postSearchProductWithoutParam() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/searchProduct")
                .when()
                .post()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertTrue(response.asString().contains("Bad request, search_product parameter is missing in POST request"));
    }
}
