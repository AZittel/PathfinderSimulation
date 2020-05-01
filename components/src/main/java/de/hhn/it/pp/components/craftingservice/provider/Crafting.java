package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * The crafting process which works independent from the rest of the program as an own Thread
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-01
 */
public class Crafting extends CraftingImplementation implements Runnable {
    private Inventory inventory;
    private CraftingPattern craftingPattern;

    /**
     * Constructor of the Crafting class
     * @param inventory the used inventory
     * @param craftingPattern the used crafting pattern
     */
    public Crafting(Inventory inventory, CraftingPattern craftingPattern) {
        this.inventory = inventory;
        this.craftingPattern = craftingPattern;
    }

    @Override
    public void run() {
        // start crafting process
        try {
            craftingStartedNotification("Crafting has started ...");
        } catch (IllegalParameterException e) {
            System.err.println(e.getMessage() + "\n");
        }
        try {
            Thread.sleep(craftingPattern.getCraftingTime());
        } catch (InterruptedException e) {}
        for (int i = 0; i < craftingPattern.getProvidedItems().size(); i++) {
            try {
                add(inventory, craftingPattern.getProvidedItems().get(i));
            } catch (IllegalParameterException e) {
                System.err.println(e.getMessage() + "\n");
            }
        }
        // crafting process has ended
        try {
            craftingEndedNotification("'" + craftingPattern.getName() + "' successfully crafted\n");
        } catch (IllegalParameterException e) {
            System.err.println(e.getMessage() + "\n");
        }
        inventory.printInventory();
        CraftingImplementation.setCraftingActive(false);
    }
}