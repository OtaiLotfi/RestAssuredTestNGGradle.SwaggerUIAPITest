package endpoints.petConfigurability.storeController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_store_inventory;
import static io.restassured.RestAssured.given;

public class GetInventory {
    public static Response getInventory() {
        return given()
                .get(base_url + petStore_store_inventory);
    }
}
