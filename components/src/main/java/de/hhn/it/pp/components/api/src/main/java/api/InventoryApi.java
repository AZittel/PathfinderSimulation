package de.hhn.it.pp.components.api.src.main.java.api;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.Collection;

public interface InventoryApi {

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the inventory e.g. "Freddys Inventory"
     * @param maxWeight maxWeight this inventory can handle
     * @param maxVolume maxVolume this inventory can handle
     */
    void addInventory(String name, Integer maxWeight, Integer maxVolume);

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
    void removeItem(Integer id);

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

    /**
     * Exchanges items between inventories
     */
    void exchangeItems();

    /**
     * Solves the Knap Sack Problem for an inventory to all items in the database
     *
     * @param id id of the inventory the Knap Sack Problem shall be solved for
     */
    void knapSack(Integer id);
}
