package de.hhn.it.pp.components.api.src.main.java.api.services;

import de.hhn.it.pp.components.api.src.main.java.api.databaseAccess.Database;
import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

import java.util.Collection;

/**
 * This class contains access to all functionalities of our component
 */
public class ApiService {


    Database dbController = AdminApiService.dbController;

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the inventory e.g. "Freddys Inventory"
     * @param maxWeight maxWeight this inventory can handle
     * @param maxVolume maxVolume this inventory can handle
     */
    public void addInventory(String name, Integer maxWeight, Integer maxVolume){
        dbController.addInventory(name, maxWeight, maxVolume);
    }

    /**
     * Removes an inventory from te database
     *
     * @param id id of the inventory to be removed
     */
    public void removeInventory(int id){
        dbController.removeInventory(id);
    }

    /**
     * Edits certain fields of an inventory
     */
    public void editInventory(Inventory inventory){
        dbController.editInventory(inventory);
    }

    /**
     * Returns a Collection of all inventories
     */
    public Collection<Inventory> retrieveInventories(Collection<Integer> ids){
        Collection<Inventory> result = dbController.retrieveInventories(ids);
        return result;
    }

    /**
     * Adds a new inventory to the database
     *
     * @param name name of the Item
     * @param weight weight of this item
     * @param volume volume of this item
     * @param value value of this item
     */
    public void addItem(String name, int weight, int volume, int value, int inventoryId){
        dbController.addItem(name, weight, volume, value, inventoryId);
    }

    /**
     * Removes an item from te database
     *
     * @param id id of the item to be removed
     */
    public void removeItem(Integer id){
        dbController.removeItem(id);
    }

    /**
     * Edits certain fields of an inventory
     */
    public void editItem(Item item){
        dbController.editItem(item);
    }

    /**
     * Returns a Collection of items
     *
     * @param ids a collection of id's of the items to be retrieved
     */
    public Collection<Item> retrieveItems(Collection<Integer> ids){
        Collection<Item> result = dbController.retrieveItems(ids);
        return result;
    }

    /**
     * Exchanges items between inventories
     */
    public void exchangeItems(){

    }

    /**
     * Solves the Knap Sack Problem for an inventory to all items in the database
     *
     * @param id id of the inventory the Knap Sack Problem shall be solved for
     */
    public void knapSack(Integer id){

    }

}
