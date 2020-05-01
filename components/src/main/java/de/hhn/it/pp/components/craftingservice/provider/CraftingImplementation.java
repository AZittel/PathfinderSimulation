package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The implementation of the component.CraftingService. Contains everything which is needed to craft new objects.
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-01
 */
public class CraftingImplementation implements CraftingService {
    // secures that only one Crafting - Thread can be active at a time
    private static boolean craftingActive;
    // no list for Threads needed because implementation allows only 1 Crafting - Thread at a time
    private static Thread currentThread;

    /**
     * The standard constructor for the implementation of the CraftingService
     */
    public CraftingImplementation() {}

    @Override
    public void add(Inventory inventory, Item item) throws IllegalParameterException {
        if (inventory == null || item == null) {
            throw new IllegalParameterException("Inventory or Crafting Pattern was null reference!\n");
        }
        inventory.getItems().add(item);
        System.out.println("'" + item.getName() + "' added into the inventory!");
    }

    @Override
    public void remove(Inventory inventory, Item item) throws IllegalParameterException {
        if (inventory == null || item == null) {
            throw new IllegalParameterException("Inventory or Crafting Pattern was null reference!\n");
        }
        if (inventory.getItems().size() == 0) {
            throw new IllegalParameterException("Inventory is empty!\n");
        }
        Iterator<Item> iterator = inventory.getItems().iterator();
        while (iterator.hasNext()) {
            Item inventoryItem = iterator.next();
            if (inventoryItem.getName().equals(item.getName())) {
                inventory.getItems().remove(inventoryItem);
                System.out.println("'" + item.getName() + "' deleted from the inventory!");
                return;
            }
        }
        throw new IllegalParameterException("'" + item.getName() + "' doesn't exist in the inventory!\n");
    }

    @Override
    public void craft(Inventory inventory, CraftingPattern craftingPattern) throws CraftingNotPossibleException {
        if (craftingActive) {
            throw new CraftingNotPossibleException("An item is already being crafted!\n");
        }
        if (inventory == null || craftingPattern == null) {
            throw new CraftingNotPossibleException("Inventory or Crafting Pattern was null reference!\n");
        }
        craftingPattern.printCraftingPattern();
        ArrayList<Item> usedItems = new ArrayList<>();
        // check if the inventory matches the crafting pattern
        for (int i = 0; i < craftingPattern.getNeededItems().size(); i++) {
            for (int j = 0; j < inventory.getItems().size(); j++) {
                if (craftingPattern.getNeededItems().get(i).getName().equals(inventory.getItems().get(j).getName())) {
                    usedItems.add(inventory.getItems().get(j));
                    try {
                        remove(inventory, inventory.getItems().get(j));
                    } catch (IllegalParameterException e) {
                        System.err.println(e.getMessage());
                    }
                    j = inventory.getItems().size();
                }
            }
        }
        // if the pattern implies the inventory: create the crafted object/s and add it/them to the inventory
        if (craftingPattern.getNeededItems().size() == usedItems.size()) {
            Crafting crafting = new Crafting(inventory, craftingPattern);
            Thread craftingThread = new Thread(crafting);
            // start crafting
            craftingActive = true;
            craftingThread.start();
            currentThread = craftingThread;
        } else { // if not: throw exception
            inventory.getItems().addAll(usedItems);
            throw new CraftingNotPossibleException("Items in inventory don't match '" +
                    craftingPattern.getName() + "'!\n");
        }
    }

    @Override
    public void craftingStartedNotification(String message) throws IllegalParameterException {
        if (message.length() <= 5) {
            throw new IllegalParameterException("Message needs at least more than five letters!");
        }
        System.out.println(message); // later: logger.info(...)
    }

    @Override
    public void craftingEndedNotification(String message) throws IllegalParameterException{
        if (message.length() <= 5) {
            throw new IllegalParameterException("Message needs at least more than five letters!");
        }
        System.out.println(message); // later: logger.info(...)
    }

    public static Thread getCurrentThread() {
        return currentThread;
    }

    public static boolean isCraftingActive() {
        return craftingActive;
    }

    public static void setCraftingActive(boolean crafting) {
        craftingActive = crafting;
    }
}
