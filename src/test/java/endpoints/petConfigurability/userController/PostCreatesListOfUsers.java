package endpoints.petConfigurability.userController;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_user;
import static io.restassured.RestAssured.given;

public class PostCreatesListOfUsers {
    public static Response postCreatesListOfUsers(String usersJsonBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(usersJsonBody)
                .when()
                .post(base_url + petStore_user + "/createWithList");
    }
}
