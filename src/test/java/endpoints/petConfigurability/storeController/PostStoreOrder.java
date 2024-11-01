package endpoints.petConfigurability.storeController;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_store_order;
import static io.restassured.RestAssured.given;

public class PostStoreOrder {
    public static Response postStoreOrder(String orderPayload) {
        return given()
                .contentType(ContentType.JSON)
                .body(orderPayload)
                .when()
                .post(base_url + petStore_store_order);
    }
}
