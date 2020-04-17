package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.Collection;

/**
 * This class implements the functionalities of our Api interface and extends the class AdminApiService so it can setup
 * the database.
 *
 * @author Dennis Schies
 * @version 1.0
 */
public class ApiService implements Api {

    //the Database this ApiService uses to retrieve and send data
    private Database database;

    /**
     * Initializes a Database object and calls it's setup method.
     */
    public ApiService() {
        this.database = new SqliteDatabase();
        this.database.setup();
    }

    /**
     * Initializes a Database object and calls it's setup method.
     *
     * @param dbPath the path to your SQLite database file
     */
    public ApiService(String dbPath) {
        this.database = new SqliteDatabase(dbPath);
        this.database.setup();
    }

    @Override
    public void addInventory(String name, int maxWeight, int maxVolume) {
        database.addInventory(name, maxWeight, maxVolume);
    }

    @Override
    public void removeInventory(int id) {
        database.removeInventory(id);
    }

    @Override
    public void editInventory(Inventory inventory) {
        database.editInventory(inventory);
    }

    @Override
    public Collection<Inventory> retrieveInventories(Collection<Integer> ids) {
        return database.retrieveInventories(ids);
    }

    @Override
    public void addItem(String name, int weight, int volume, int value, int inventoryId) {
        database.addItem(name, weight, volume, value, inventoryId);
    }

    @Override
    public void removeItem(Integer id) {
        database.removeItem(id);
    }

    @Override
    public void editItem(Item item) {
        database.editItem(item);
    }

    @Override
    public Collection<Item> retrieveItems(Collection<Integer> ids) {
        Collection<Item> result = database.retrieveItems(ids);
        return result;
    }

//    //under development
//    /**
//     * Exchanges items between inventories
//     */
//    public void exchangeItems(){
//
//    }
//
//    /**
//     * Solves the Knap Sack Problem for an inventory to all items in the database
//     *
//     * @param id id of the inventory the Knap Sack Problem shall be solved for
//     */
//    public void knapSack(int id){
//
//    }

}
