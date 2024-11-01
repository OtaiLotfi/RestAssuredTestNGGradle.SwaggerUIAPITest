package endpoints.petConfigurability.userController;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class PutUpdateUser {
    public static Response putUpdateUser(String requestBody, String username) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(base_url + petStore_user + "/" + username);
    }
}
