package endpoints.petConfigurability.storeController;

import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_store_order;
import static io.restassured.RestAssured.given;

public class DeletePurchaseOrderById {
    public static Response deletePurchaseOrderById(int orderId) {
        return given()
                .pathParam("orderId", orderId)
                .when()
                .delete(base_url + petStore_store_order + "/{orderId}");
    }
}
