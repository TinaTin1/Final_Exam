package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllBrandsTest {

    @Test
    public void getAllBrands() {
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/brandsList")
                .when()
                .get()
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertFalse(response.jsonPath().getList("brands").isEmpty(), "Brands list should not be empty");
    }
}
