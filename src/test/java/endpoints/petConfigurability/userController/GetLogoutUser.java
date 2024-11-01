package endpoints.petConfigurability.userController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class GetLogoutUser {
    public static Response getLogoutUser() {
        return given()
                .when()
                .get(base_url + petStore_user + "/logout");
    }
}
