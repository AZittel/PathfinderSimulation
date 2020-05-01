package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.provider.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.provider.Inventory;
import de.hhn.it.pp.components.craftingservice.provider.Item;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;


/**
 * The component.CraftingService interface, which contains all relevant methods
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-01
 */
public interface CraftingService {

    /**
     * Add a specific item to the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     * @throws IllegalParameterException, if inventory or craftingPattern are null
     */
    void add(Inventory inventory, Item item) throws IllegalParameterException;

    /**
     * Remove a specific item from the provided inventory
     * @param inventory, the provided inventory
     * @param item, the provided item
     * @throws IllegalParameterException, if inventory or craftingPattern are null,
     *                                    or if the inventory contains no items,
     *                                    or if the searched item doesn't exist in the inventory
     */
    void remove(Inventory inventory, Item item) throws IllegalParameterException;

    /**
     * Craft a specific pattern if possible and add it to the inventory
     * @param inventory, the provided inventory
     * @param craftingPattern, the provided pattern
     * @throws CraftingNotPossibleException, if inventory or craftingPattern are null,
     *                                       or if items in inventory don't match crafting Pattern,
     *                                       or if an item is already being crafted
     */
    void craft(Inventory inventory, CraftingPattern craftingPattern) throws CraftingNotPossibleException;

    /**
     * Notification callback, if the crafting process has started
     * @param message individual message
     * @throws IllegalParameterException, if message is too short
     */
    void craftingStartedNotification(String message) throws IllegalParameterException;

    /**
     * Notification callback, if the crafting process has ended
     * @param message individual message
     * @throws IllegalParameterException, if message is too short
     */
    void craftingEndedNotification(String message) throws IllegalParameterException;
}