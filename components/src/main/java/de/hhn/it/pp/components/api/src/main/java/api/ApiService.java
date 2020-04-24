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
    private DatabaseController dbController;

    /**
     * Initializes a Database object and calls it's setup method.
     */
    public ApiService() {
        database = new SqliteDatabase();
        database.setup();
        dbController = new DatabaseController(database);
    }

    /**
     * Initializes a Database object and calls it's setup method.
     *
     * @param dbPath the path to your SQLite database file
     */
    public ApiService(String dbPath) {
        database = new SqliteDatabase(dbPath);
        database.setup();
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
    public Inventory retrieveInventory(int id) {
        return database.retrieveInventory(id);
    }
    @Override
    public Collection<Inventory> retrieveAllInventories() {
        return database.retrieveAllInventories();
    }

    @Override
    public Collection<Inventory> retrieveInventories(Collection<Integer> ids) {
        return database.retrieveInventories(ids);
    }

    @Override
    public void addItem(String name, int weight, int volume, int value) {
        database.addItem(name, weight, volume, value);
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
    public Item retrieveItem(int id) {
        return database.retrieveItem(id);
    }
    @Override
    public Collection<Item> retrieveAllItems() {
        return database.retrieveAllItems();
    }

    @Override
    public Collection<Item> retrieveItems(Collection<Integer> ids) {
        return database.retrieveItems(ids);
    }

    @Override
    public void moveItem(Item item, int inventoryId) {
        dbController.moveItem(item,inventoryId);
    }

    @Override
    public Collection<Item> knapSack(int id) {
        return dbController.knapSack(id);
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
