package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.provider.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.provider.Item;

import java.util.List;

/**
 * The CraftingService interface, which contains all relevant methods
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-04-09
 */
public interface CraftingService {

    /**
     * Add a specific item to the provided inventory
     * @param inventory, the provided inventory
     * @param inventorySize, the size of the inventory
     * @param item, the provided item
     * @return true, if the item could be added, false if not
     */
    boolean add(List<Item> inventory, int inventorySize, Item item);

    /**
     * Remove a specific item from the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     * @return true, if item was found, false if not
     */
    boolean remove(List<Item> inventory, Item item);

    /**
     * Craft a specific pattern if possible and add it to the inventory
     * @param inventory, the provided inventory
     * @param  inventorySize, the size of the inventory
     * @param craftingPattern, the provided pattern
     * @return true, if pattern could be crafted, false if not
     */
    boolean craft(List<Item> inventory, int inventorySize, CraftingPattern craftingPattern);
}