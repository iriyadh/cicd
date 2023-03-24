package RestAssuredTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ValidateResponse {
    @Test
    public void getMethodCall(){
        RestAssured.baseURI = "http://reqres.in/api/users";

        given().queryParam("page", "2").header("Content-Type", "application/json").
                when().get().then().log().all().assertThat().statusCode(200);
    }
}
