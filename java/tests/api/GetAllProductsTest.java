package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllProductsTest {

    @Test
    public void getAllProducts() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/productsList")
                .when()
                .get()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(response.jsonPath().getList("products").isEmpty(), "Products list should not be empty");
    }
}
