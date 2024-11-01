package test.petStoreTests;

import endpoints.Pet;
import endpoints.ScenarioContext;
import endpoints.petConfigurability.petController.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static endpoints.Common.convertJsonFilToString;
import static endpoints.ScenarioContextKeys.GET_PET_BY_ID;
import static endpoints.ScenarioContextKeys.POST_PET_Upload_Image;

public class PetTests {
    private static final String PET_ID = "12345";
    File uploadedImage = new File("src/test/java/payloads/petStore/image.png");
    String petBodyAvailableStatusJsonFile = "src/test/java/payloads/petStore/petBodyAvailableStatus.json";
    String petBodyPendingStatusJsonFile = "src/test/java/payloads/petStore/petBodyPendingStatus.json";
    String petByIdAvailableStatusJsonFile = "src/test/java/payloads/petStore/petByIdAvailableStatus.json";
    String petByIdPendingStatusJsonFile = "src/test/java/payloads/petStore/petByIdPendingStatus.json";
    String petByIdSoldStatusJsonFile = "src/test/java/payloads/petStore/petByIdSoldStatus.json";
    String petBodySoldStatusJsonFile = "src/test/java/payloads/petStore/petBodySoldStatus.json";
    String UpdateExistingPetFile = "src/test/java/payloads/petStore/UpdateExistingPet.json";
    Pet newPet = new Pet();

    @Test
    public void postPetUploadImageTest() {
        newPet.setId(12345L);
        Response postResponse = PostPetUploadImage.postPetUploadImage(newPet.getId(), uploadedImage, "This is a pet image.");
        Assert.assertEquals(postResponse.statusCode(), 200);
        String postResult = postResponse.getBody().asString();
        ScenarioContext.getInstance().setScenarioContext(POST_PET_Upload_Image, postResult);
        ScenarioContext.getInstance().getScenarioContext(POST_PET_Upload_Image).toString();
    }

    @Test
    public void postAddANewAvailablePetToTheStoreTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petBodyAvailableStatusJsonFile);
        Response postResponse = PostAddANewPetToTheStore.postAddANewPetToTheStore(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void postAddANewPendingPetToTheStoreTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petBodyPendingStatusJsonFile);
        Response postResponse = PostAddANewPetToTheStore.postAddANewPetToTheStore(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void postAddANewSoldPetToTheStoreTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petBodySoldStatusJsonFile);
        Response postResponse = PostAddANewPetToTheStore.postAddANewPetToTheStore(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void putUpdateExistingPetTest() throws IOException {
        String ExistingPetFileContent = new String(Files.readAllBytes(Paths.get(UpdateExistingPetFile)));
        Response putResponse = PutUpdateExistingPet.putUpdateExistingPet(ExistingPetFileContent);
        Assert.assertEquals(putResponse.statusCode(), 200);
    }

    @Test
    public void getAndFindPetsByAvailableStatusTest() {
        newPet.setStatus("available");
        Response getResult = GetAndFindPetsByStatus.getAndFindPetsByStatus(newPet.getStatus());
        Assert.assertEquals(getResult.statusCode(), 200);
    }

    @Test
    public void getAndFindPetsByPendingStatusTest() {
        newPet.setStatus("pending");
        Response getResult = GetAndFindPetsByStatus.getAndFindPetsByStatus(newPet.getStatus());
        Assert.assertEquals(getResult.statusCode(), 200);
    }

    @Test
    public void getAndFindPetsBySoldStatusTest() {
        newPet.setStatus("sold");
        Response getResult = GetAndFindPetsByStatus.getAndFindPetsByStatus(newPet.getStatus());
        Assert.assertEquals(getResult.statusCode(), 200);
    }

    @Test
    public void getPetByIdTest() {
        Response getResponse = GetPetById.getPetById(5);
        String getResult = getResponse.getBody().asString();
        ScenarioContext.getInstance().setScenarioContext(GET_PET_BY_ID, getResult);
        ScenarioContext.getInstance().getScenarioContext(GET_PET_BY_ID).toString();
    }

    @Test
    public void postPetByIdAvailableStatusTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petByIdAvailableStatusJsonFile);
        Response postResponse = PostPetById.postPetById(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void postPetByIdPendingStatusTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petByIdPendingStatusJsonFile);
        Response postResponse = PostPetById.postPetById(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void postPetByIdSoldStatusTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(petByIdSoldStatusJsonFile);
        Response postResponse = PostPetById.postPetById(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void deletePetTest() {
        Response deleteResponse = DeletePet.deletePet(PET_ID);
        Assert.assertEquals(deleteResponse.statusCode(), 200);
    }
}
