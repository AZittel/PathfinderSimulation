package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.provider.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.provider.Item;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

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
     * @throws IllegalParameterException, if inventorySize <= 0 and if inventorySize < inventory.Size()
     * @throws OperationNotSupportedException, if inventory.size() == inventorySize
     */
    boolean add(List<Item> inventory, int inventorySize, Item item)
            throws IllegalParameterException, OperationNotSupportedException;

    /**
     * Remove a specific item from the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     * @return true, if item was found, false if not
     * @throws OperationNotSupportedException, if inventory.size() == 0
     */
    boolean remove(List<Item> inventory, Item item) throws OperationNotSupportedException;

    /**
     * Craft a specific pattern if possible and add it to the inventory
     * @param inventory, the provided inventory
     * @param  inventorySize, the size of the inventory
     * @param craftingPattern, the provided pattern
     * @return true, if pattern could be crafted, false if not
     * @throws IllegalParameterException, if inventorySize <= 0 and if inventorySize < inventory.size()
     */
    boolean craft(List<Item> inventory, int inventorySize, CraftingPattern craftingPattern)
            throws IllegalParameterException;
}