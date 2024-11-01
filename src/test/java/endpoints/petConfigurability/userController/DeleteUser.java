package endpoints.petConfigurability.userController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class DeleteUser {
    public static Response deleteUser(String username) {
        return given()
                .when()
                .delete(base_url + petStore_user + "/" + username);
    }
}
