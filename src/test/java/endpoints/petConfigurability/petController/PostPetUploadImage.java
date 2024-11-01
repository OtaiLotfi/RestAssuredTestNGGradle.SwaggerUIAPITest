package endpoints.petConfigurability.petController;

import io.restassured.response.Response;

import java.io.File;

import static endpoints.RoutesConfig.base_url;
import static endpoints.RoutesConfig.petStore_pet_uploadImage;
import static io.restassured.RestAssured.given;

public class PostPetUploadImage {
    public static Response postPetUploadImage(Long petId, File file, String additionalMetadata) {
        return given()
                .pathParam("petId", petId)
                .multiPart("file", file)
                .formParam("additionalMetadata", additionalMetadata)
                .when()
                .post(base_url + petStore_pet_uploadImage);
    }
}
