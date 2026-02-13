package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostSearchProductTest {

    @Test
    public void postSearchProduct() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/searchProduct")
                .param("search_product", "top")
                .when()
                .post()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(response.jsonPath().getList("products").isEmpty(), "Searched products list should not be empty");
    }
}
