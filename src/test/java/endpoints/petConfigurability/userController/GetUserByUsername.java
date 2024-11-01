package endpoints.petConfigurability.userController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class GetUserByUsername {
    public static Response getUserByUsername(String username) {
        return given()
                .pathParam("username", username)
                .when()
                .get(base_url + petStore_user + "/{username}");
    }
}
