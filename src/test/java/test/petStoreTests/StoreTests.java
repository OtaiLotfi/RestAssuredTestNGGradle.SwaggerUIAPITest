package test.petStoreTests;

import endpoints.ScenarioContext;
import endpoints.petConfigurability.storeController.DeletePurchaseOrderById;
import endpoints.petConfigurability.storeController.GetInventory;
import endpoints.petConfigurability.storeController.GetPurchaseOrderById;
import endpoints.petConfigurability.storeController.PostStoreOrder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static endpoints.Common.convertJsonFilToString;
import static endpoints.ScenarioContextKeys.DELETE_STATUS_CODE;

public class StoreTests {
    String storeOrderJsonFile = "src/test/java/payloads/petStore/storeOrder.json";

    @DataProvider(name = "orderIdProvider")
    public Object[][] orderIdsProvider() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test
    public void GetInventoryTest() {
        Response postResponse = GetInventory.getInventory();
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void PostStoreOrderTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(storeOrderJsonFile);
        Response postResponse = PostStoreOrder.postStoreOrder(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void getPurchaseOrderByIdTest() {
        Response postResponse = GetPurchaseOrderById.getPurchaseOrderById(1);
        //Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test(dataProvider = "orderIdProvider")
    public void deletePurchaseOrderByIdTest(int orderId) {
        Response deleteResponse = DeletePurchaseOrderById.deletePurchaseOrderById(orderId);
        int statusCodeResult = deleteResponse.statusCode();
        ScenarioContext.getInstance().setScenarioContext(DELETE_STATUS_CODE, statusCodeResult);
        ScenarioContext.getInstance().getScenarioContext(DELETE_STATUS_CODE).toString();
    }
}
