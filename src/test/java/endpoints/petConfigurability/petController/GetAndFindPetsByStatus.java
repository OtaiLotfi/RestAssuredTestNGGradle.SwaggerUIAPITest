package endpoints.petConfigurability.petController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet_findByStatus;
import static io.restassured.RestAssured.given;

public class GetAndFindPetsByStatus {
    public static Response getAndFindPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get(base_url + petStore_pet_findByStatus);
    }
}
