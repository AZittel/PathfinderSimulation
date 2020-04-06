/**
 * The Interface for the 'CraftingService' which contains all relevant methods
 * @authors Oliver Koch, Philipp Alessandrini
 * @version 2020-04-05
 */

package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public interface CraftingServiceInterface {

    /**
     * Start the Gui
     */
    void startProgram();

    /**
     * Add a specific item to the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     */
    void addToInventory(ArrayList<Item> inventory, Item item);

    /**
     * Remove a specific item from the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     * @return true, if item was found, false if not
     */
    boolean removeFromInventory(ArrayList<Item> inventory, Item item);

    /**
     * Craft a specific pattern if possible and add it to the inventory
     * @param inventory, the provided inventory
     * @param craftingPattern, the provided pattern
     * @return true, if pattern could be crafted, false if not
     */
    boolean craft(ArrayList<Item> inventory, CraftingPattern craftingPattern);

    /**
     * Exit the Gui
     */
    void exitProgram();
}
