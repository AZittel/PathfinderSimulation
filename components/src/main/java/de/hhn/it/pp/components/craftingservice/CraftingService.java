/**
 * Contains everything the Crafting Service needs to craft items and also contains some
 * example methods for specific items as an application example e.g. wood or iron
 * for the subsequent Demo-UI
 * @authors Oliver Koch, Philipp Alessandrini
 * @version 2020-04-05
 */

package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;
import java.util.Iterator;

public class CraftingService implements CraftingServiceInterface {
    private static ArrayList<Item> inventory = new ArrayList<>();
    private static final int INVENTORY_SIZE = 18;

    @Override
    public void startProgram() {}

    @Override
    public void exitProgram() {}

    @Override
    public void addToInventory(ArrayList<Item> inventory, Item item) {
        if (inventory.size() < INVENTORY_SIZE) {
            inventory.add(item);
        } else {
            System.out.println("Inventory is full!");
        }
    }

    @Override
    public boolean removeFromInventory(ArrayList<Item> inventory, Item item) {
        Iterator<Item> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Item itemInventory = iterator.next();
            if (itemInventory.getName().equals(item.getName())) {
                inventory.remove(itemInventory);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean craft(ArrayList<Item> inventory, CraftingPattern craftingPattern) {
        ArrayList<Item> usedItems = new ArrayList<>();
        // check the inventory
        for (int i = 0; i < craftingPattern.getNeededItems().size(); i++) {
            for (int j = 0; j < inventory.size(); j++) {
                if (craftingPattern.getNeededItems().get(i).getName().equals(inventory.get(j).getName())) {
                    usedItems.add(inventory.get(j));
                    removeFromInventory(inventory, inventory.get(j));
                    j = inventory.size();
                }
            }
        }
        // create the crafted object and add it to the inventory if the pattern implies the inventory
        if (craftingPattern.getNeededItems().size() == usedItems.size()) {
            // Wait some time: craftingPattern.getCraftedWeapon().getCraftingTime();
            addToInventory(inventory, craftingPattern.getCraftedWeapon());
            System.out.println("" + craftingPattern.getCraftedWeapon().getName() + " successfully crafted!");
            return true;
        } else {
            inventory.addAll(usedItems);
            System.out.println("Items in inventory dont match the chosen pattern for " +
                    craftingPattern.getCraftedWeapon().getName());
            return false;
        }
    }

    /**
     * Add wood into the inventory
     * @param name, the wood - type
     */
    public void addWood(String name) {
        addToInventory(inventory, new Wood(name));
    }

    /**
     * Add iron into the inventory
     * @param name, the iron - type
     */
    public void addIron(String name) {
        addToInventory(inventory, new Iron(name));
    }

    /**
     * Add an essence into the inventory
     * @param name, the essence - type
     */
    public void addEssence(String name) {
        addToInventory(inventory, new Essence(name));
    }

    /**
     * Choose a specific pattern to craft for
     * @param name, the name of the pattern
     */
    public void useCraftingPattern(String name) {
        switch (name) {
            case "Pattern: Fiery Sword":
                craft(inventory, new CraftingPattern(name, new Sword("Large Iron Sword", 1.0f),
                        new Essence("Fiery Essence"), new Sword("Firey Sword", 2.5f)));
                break;

            case "Pattern: Large Iron Sword":
                craft(inventory, new CraftingPattern(name, new Wood("Small Wood Plank"),
                        new Iron("Medium Iron Bar"), new Iron("Medium Iron Bar"),
                        new Sword("Large Iron Sword", 1.0f)));
                break;

            case "Pattern: Small Magical Wand":
                craft(inventory, new CraftingPattern(name, new Wood("Small Wood Plank"),
                        new Essence("Magical Essence"), new Wand("Small Magical Wand", 1.0f)));
                break;

            default:
                System.out.println("Pattern doesn't exist");
        }
    }
}
