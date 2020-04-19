package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.Collection;

/**
 * This interface is there for defining the basic database access functionalities
 * all databases have to implement.
 *
 * @author Dennis Schies
 * @version 1.0
 */
interface Database {

    /**
     * Creates the database tables for inventories and items if they do not already exist.
     */
    void setup();

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the inventory e.g. "Freddys Inventory"
     * @param maxWeight maxWeight this inventory can handle
     * @param maxVolume maxVolume this inventory can handle
     */
    void addInventory(String name, int maxWeight, int maxVolume);

    /**
     * Removes an inventory from te database
     *
     * @param id id of the inventory to be removed
     */
    void removeInventory(int id);

    /**
     * Edits certain fields of an inventory
     */
    void editInventory(Inventory inventory);

    /**
     * Returns a Collection of all inventories
     */
    Collection<Inventory> retrieveAllInventories();

    /**
     * Returns a Collection of all inventories
     */
    Collection<Inventory> retrieveInventories(Collection<Integer> ids);

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value value of this item
     */
    void addItem(String name, int weight, int volume, int value, int inventoryId);

    /**
     * Removes an item from te database
     *
     * @param id id of the item to be removed
     */
    void removeItem(int id);

    /**
     * Edits certain fields of an inventory
     */
    void editItem(Item item);

    /**
     * Returns a Collection of items
     *
     * @param ids a collection of id's of the items to be retrieved
     */
    Collection<Item> retrieveItems(Collection<Integer> ids);


//    //under development
//    // add whatever model
//    void addModel(Model model);
//
//    //remove whatever model
//    void removeModel(Model model);
//
//    //edit whatever model fields
//    void editModel(Model model);
//
//    //retrieve a list of whatever models
//    Collection<Model> retrieveModels(String modelType,Collection<int> modelIds);
//
//    //create a table of whatever model
//    void createTableFromModel(Model model);


}
