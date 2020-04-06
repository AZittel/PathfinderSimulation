package de.hhn.it.pp.components.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.*;
import de.hhn.it.pp.components.api.src.main.java.api.services.AdminApiService;
import de.hhn.it.pp.components.api.src.main.java.api.services.ApiService;

import java.util.Collection;

public class DemoApiUsage {

    public static void main(String[] args) {
        // initializing the database connection
        AdminApiService adminApi = new AdminApiService();
        adminApi.initilizeDatabase();

        // creating ApiService object to interact with the database
        ApiService api = new ApiService();

        // adding a few inventories to the database
        api.addInventory("My inventory", 80, 50);
        api.addInventory("Freddy's inventory", 30, 20);

        // retrieving the inventories
        Collection<Inventory> inventories = api.retrieveInventories();

        // printing the values of each inventory
        for (Inventory inventory : inventories) {
            System.out.println(inventory.toString());
        }
    }
}
