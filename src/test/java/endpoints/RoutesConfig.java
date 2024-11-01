package endpoints;

import java.util.ResourceBundle;

public class RoutesConfig {
    public static ResourceBundle getURL() {
        return ResourceBundle.getBundle("config");
    }

    public static final String base_url = getURL().getString("petStore-base-url");
    public static final String petStore_user = getURL().getString("petStore-user");
    public static final String petStore_store_order = getURL().getString("petStore-store-order");
    public static final String petStore_store_inventory = getURL().getString("petStore-store-inventory");
    public static final String petStore_pet = getURL().getString("petStore-pet");
    public static final String petStore_pet_uploadImage = getURL().getString("petStore-pet-uploadImage");
    public static final String petStore_pet_findByStatus = getURL().getString("petStore-pet-findByStatus");
    public static final String petStore_username = getURL().getString("petStore-username");
    public static final String petStore_password = getURL().getString("petStore-password");
}