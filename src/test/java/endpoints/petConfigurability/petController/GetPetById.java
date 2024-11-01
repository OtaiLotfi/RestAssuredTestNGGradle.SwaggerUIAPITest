package endpoints.petConfigurability.petController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet;
import static io.restassured.RestAssured.given;

public class GetPetById {
    public static Response getPetById(int petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .get(base_url + petStore_pet + "/{petId}");
    }
}
