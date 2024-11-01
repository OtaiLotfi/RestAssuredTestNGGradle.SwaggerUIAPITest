package endpoints.petConfigurability.petController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet;
import static io.restassured.RestAssured.given;

public class DeletePet {
    public static Response deletePet(String petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .delete(base_url + petStore_pet + "/{petId}");
    }
}
