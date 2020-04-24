package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.Collection;

/**
 * This interface defines the basic functionalities the inventory api must implement.
 *
 * @author Dennis Schies
 * @version 1.0
 */
public interface Api {

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
     *
     * @param inventory the inventory to be edited containing its values
     */
    void editInventory(Inventory inventory);

    /**
     * Returns a single inventory
     *
     * @param id id of the inventory to be retrieved
     */
    Inventory retrieveInventory(int id);

    /**
     * Returns a Collection of all inventories
     */
    Collection<Inventory> retrieveAllInventories();

    /**
     * Returns a Collection of inventories
     *
     *@param ids a collection of id's of the items to be retrieved
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
    void addItem(String name, int weight, int volume, int value);

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value value of this item
     * @param inventoryId the id of the inventory this item is contained in
     */
    void addItem(String name, int weight, int volume, int value, int inventoryId);

    /**
     * Removes an item from te database
     *
     * @param id id of the item to be removed
     */
    void removeItem(Integer id);

    /**
     * Edits certain fields of an inventory
     *
     * @param item the item to be edited containing its values
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
     * Moves an item from one inventory to another
     *
     * @param item the item to be moved
     * @param inventoryId the id of the target inventory the item shall be moved to
     */
    void moveItem(Item item, int inventoryId);

    /**
     * Solves the Knap Sack Problem for an inventory to all items in the database
     *
     * @param id id of the inventory the Knap Sack Problem shall be solved for
     */
    Collection<Item> knapSack(int id);
}
