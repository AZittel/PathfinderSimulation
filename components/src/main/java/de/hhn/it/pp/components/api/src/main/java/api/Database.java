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
     * Returns a single inventory
     *
     * @param id the id of the inventory to be retrieved
     */
    Inventory retrieveInventory(int id);

    /**
     * Returns a Collection of all inventories
     */
    Collection<Inventory> retrieveAllInventories();

    /**
     * Returns a Collection of inventories
     *
     * @param ids a collection of id's of the items to be retrieved
     */
    Collection<Inventory> retrieveInventories(Collection<Integer> ids);

    /**
     * Adds a new item to the database
     *
     * @param name name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value value of this item
     */
    void addItem(String name, int weight, int volume, int value);

    /**
     * Adds a new item to the database
     *
     * @param name name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value value of this item
     * @param inventoryId the id of the inventory this item is put in
     */
    void addItem(String name, int weight, int volume, int value,int inventoryId);

    /**
     * Removes an item from te database
     *
     * @param id id of the item to be removed
     */
    void removeItem(int id);

    /**
     * Edits certain fields of an item
     */
    void editItem(Item item);

    /**
     * Returns a single item
     *
     * @param id id of the item to be retrieved
     */
    Item retrieveItem(int id);

    /**
     * Returns a Collection of all items
     */
    Collection<Item> retrieveAllItems();

    /**
     * Returns a Collection of items
     *
     * @param ids a collection of id's of the items to be retrieved
     */
    Collection<Item> retrieveItems(Collection<Integer> ids);

    /**
     * Returns true if the allocation between an item and an inventory is doable
     * and false if one of the inventory limits would be exceeded.
     *
     *
     * */
    Boolean getItemInventoryAllocation(int weight, int volume, int inventoryId);

    /**
     * Returns the sum of value for each item which inventoryId is equal to the input
     *
     * @param id the id of the inventory which we want to calculate the currentValue for
     */
    void calculateCurrentValue(int id);

}
