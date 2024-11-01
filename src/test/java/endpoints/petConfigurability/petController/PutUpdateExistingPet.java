package endpoints.petConfigurability.petController;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet;
import static io.restassured.RestAssured.given;

public class PutUpdateExistingPet {
    public static Response putUpdateExistingPet(String ExistingPetFileContent) {
        return given()
                .contentType(ContentType.JSON)
                .body(ExistingPetFileContent)
                .when()
                .put(base_url + petStore_pet);
    }
}
