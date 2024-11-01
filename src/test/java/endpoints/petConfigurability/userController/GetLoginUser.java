package endpoints.petConfigurability.userController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class GetLoginUser {
    public static Response getLoginUser(String username, String password) {
        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .get(base_url + petStore_user + "/login");
    }
}
