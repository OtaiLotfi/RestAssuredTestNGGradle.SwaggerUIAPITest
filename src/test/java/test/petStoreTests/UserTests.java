package test.petStoreTests;

import endpoints.petConfigurability.userController.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static endpoints.Common.convertJsonFilToString;

import static endpoints.RoutesConfig.petStore_password;
import static endpoints.RoutesConfig.petStore_username;

public class UserTests {
    private static final String UPDATED_USER_NAME = "Otai_Lotfi";
    String listOfUsersJsonFile = "src/test/java/payloads/petStore/users.json";
    File userJsonFile = new File("src/test/java/payloads/petStore/user.json");
    String updatedUserJsonFile = "src/test/java/payloads/petStore/updatedUser.json";

    @Test
    public void postCreatesListOfUsersTest() throws IOException {
        String convertJsonFileToString = convertJsonFilToString(listOfUsersJsonFile);
        Response postResponse = PostCreatesListOfUsers.postCreatesListOfUsers(convertJsonFileToString);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void postCreateUserTest() {
        Response postResponse = PostCreateUser.postCreateUser(userJsonFile);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void getUserByUsernameTest() {
        Response postResponse = GetUserByUsername.getUserByUsername(petStore_username);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void putUpdateUserTest() throws IOException {
        String requestBody = new String(Files.readAllBytes(Paths.get(updatedUserJsonFile)));
        Response postResponse = PutUpdateUser.putUpdateUser(requestBody, UPDATED_USER_NAME);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void deleteUserTest() {
        Response postResponse = DeleteUser.deleteUser(petStore_username);
        String actualResult = postResponse.getBody().asString();
    }

    @Test
    public void getLoginUserTest() {
        Response postResponse = GetLoginUser.getLoginUser(petStore_username, petStore_password);
        Assert.assertEquals(postResponse.statusCode(), 200);
    }

    @Test
    public void getLogoutUserTest() {
        Response postResponse = GetLogoutUser.getLogoutUser();
        Assert.assertEquals(postResponse.statusCode(), 200);
    }
}
