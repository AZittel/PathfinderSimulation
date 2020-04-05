/**
 * A program demo to show of the basic feature of the crafting systems
 * (concrete items in inventory during the crafting can be checked with the debugger)
 *
 * @authors Oliver Koch, Philipp Alessandrini
 * @version 2020-04-05
 */

package de.hhn.it.pp.components.craftingservice;

public class CraftingServiceUsageDemo {

    public static void main(String[] args) {
        // -- demonstrate a demo scenario
        CraftingService demo = new CraftingService();

        // add some resources into the inventory
        demo.addWood("Small Wood Plank");
        demo.addEssence("Magical Essence");
        demo.addEssence("Fiery Essence");
        demo.addIron("Medium Iron Bar");
        demo.addIron("Medium Iron Bar");
        demo.addIron("Medium Iron Bar");

        // try to craft some patterns
        demo.useCraftingPattern("Pattern: Large Iron Sword");
        demo.useCraftingPattern("Pattern: Fiery Sword");
        // this should not work because there is no 'Small Wood Plank' in the inventory anymore
        demo.useCraftingPattern("Pattern: Small Magical Wand");
    }
}
