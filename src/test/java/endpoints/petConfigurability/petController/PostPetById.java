package endpoints.petConfigurability.petController;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet;
import static io.restassured.RestAssured.given;

public class PostPetById {
    public static Response postPetById(String newPet) {
        return given()
                .contentType(ContentType.JSON)
                .body(newPet)
                .when()
                .post(base_url + petStore_pet);
    }
}
