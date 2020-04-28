package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.provider.*;

/**
 * A program demo to show off the basic feature of the crafting system
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-04-20
 */

public class CraftingServiceUsageDemo {

    public static void main(String[] args) {
        // --- INITIALIZATION --

        // create an inventory
        Inventory demoInventory = new Inventory(18);
        // create some resources
        Resource smallWoodPlank = new Resource("Small Wood Plank");
        Resource magicalEssence = new Resource("Magical Essence");
        Resource fieryEssence = new Resource("Fiery Essence");
        Resource mediumIronBar = new Resource("Medium Iron Bar");
        // create some crafting patterns
        CraftingPattern largeIronSword = new CraftingPattern(1.5f,
                new Resource("Small Wood Plank"), new Resource("Medium Iron Bar"),
                new Resource("Medium Iron Bar"), new Weapon("Large Iron Sword"));
        CraftingPattern fierySword = new CraftingPattern(2.5f,
                new Weapon("Large Iron Sword"), new Resource("Fiery Essence"),
                new Weapon("Fiery Sword"));
        CraftingPattern smallMagicalWand = new CraftingPattern(1.0f,
                new Resource("Small Wood Plank"), new Resource("Magical Essence"),
                new Weapon("Small Magical Wand"));

        // --- DEMO SCENARIO ---

        // add the resources into the inventory
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), smallWoodPlank);
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), magicalEssence);
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), fieryEssence);
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), mediumIronBar);
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), mediumIronBar);
        demoInventory.add(demoInventory.getItems(), demoInventory.getInventorySize(), mediumIronBar);

        // print the inventory first
        demoInventory.printInventory();

        // try to craft some patterns and print the needed and provided items of each pattern before
        largeIronSword.printCraftingPattern();
        demoInventory.craft(demoInventory.getItems(), demoInventory.getInventorySize(), largeIronSword);
        // this should work - print updated inventory
        demoInventory.printInventory();

        fierySword.printCraftingPattern();
        demoInventory.craft(demoInventory.getItems(), demoInventory.getInventorySize(), fierySword);
        // this should work - print updated inventory
        demoInventory.printInventory();

        smallMagicalWand.printCraftingPattern();
        demoInventory.craft(demoInventory.getItems(), demoInventory.getInventorySize(), smallMagicalWand);
        // this should not work because there is no 'Small Wood Plank' in the inventory anymore - print inventory
        demoInventory.printInventory();

        // try to delete the 'Magical Essence' form the inventory
        if(demoInventory.remove(demoInventory.getItems(), magicalEssence)) {
            System.out.println("'" + magicalEssence.getName() + "' deleted from inventory!\n");
        } else {
            System.out.println("Inventory is empty or item doesn't exist!\n");
        }
        // this should work - print updated inventory
        demoInventory.printInventory();
    }
}