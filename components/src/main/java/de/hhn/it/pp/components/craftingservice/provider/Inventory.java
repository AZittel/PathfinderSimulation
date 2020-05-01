package de.hhn.it.pp.components.craftingservice.provider;

import java.util.List;

/**
 * The inventory class which implements the component.CraftingService to enable the feature for craftable items
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-01
 */
public class Inventory {
    private List<Item> items;

    /**
     * The constructor for the inventory class
     * @param items, the items which are inside the inventory
     */
    public Inventory(List<Item> items) {
        this.items = items;
    }

    /**
     * Print all items contained in the inventory to the console
     */
    public void printInventory() {
        System.out.println("Items in inventory: ");
        for (Item inventoryItem : items) {
            System.out.println("- " + inventoryItem.getName());
        }
        System.out.println();
    }

    public List<Item> getItems() {
        return items;
    }
}