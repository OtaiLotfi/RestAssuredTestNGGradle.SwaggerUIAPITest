package endpoints.petConfigurability.userController;

import io.restassured.response.Response;

import java.io.File;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class PostCreateUser {
    public static Response postCreateUser(File userJsonFile) {
        return given()
                .contentType("application/json")
                .body(userJsonFile)
                .when()
                .post(base_url + petStore_user);
    }
}
