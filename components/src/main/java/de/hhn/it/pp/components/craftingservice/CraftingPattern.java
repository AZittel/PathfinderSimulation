package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for crafting patterns.
 * Right now there are 3 different patterns(small weapons, large weapons, enchanted weapons).
 */
public class CraftingPattern {
    /** A static list which holds all crafting patterns. **/
    private static ArrayList<CraftingPattern> allCraftingPatterns = new ArrayList<>();
    /** A list for every crafting pattern, which holds the needed items to craft the described weapon. **/
    private ArrayList<Item> neededItems = new ArrayList<>();
    /** A field weapon for the crafted weapon. **/
    private Weapon craftedWeapon;
    /** The name of the weapon. **/
    private String name;

    // small weapons
    /**
     * The constructor for small weapons.
     * @param name The name of the crafting pattern.
     * @param neededResource1 The needed resource number 1 to craft the weapon.
     * @param neededResource2 The needed resource number 2 to craft the weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(String name, Resource neededResource1, Resource neededResource2, Weapon craftedWeapon) {
        this.name = name;
        neededItems.add(neededResource1);
        neededItems.add(neededResource2);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }
    // large weapons
    /**
     * The constructor for large weapons.
     * @param name The name of the crafting pattern.
     * @param neededResource1 The needed resource number 1 to craft the weapon.
     * @param neededResource2 The needed resource number 2 to craft the weapon.
     * @param neededResource3 The needed resource number 3 to craft the weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(String name, Resource neededResource1, Resource neededResource2, Resource neededResource3,
                           Weapon craftedWeapon) {
        this.name = name;
        neededItems.add(neededResource1);
        neededItems.add(neededResource2);
        neededItems.add(neededResource3);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }
    // enchanted weapons
    /**
     * The constructor for enchanted weapons. It is an enchanting pattern but works the same way.
     * @param name The name of the crafting pattern.
     * @param neededWeapon The needed weapon to craft the enchanted weapon(the unenchanted weapon will be lost).
     * @param neededEssence The needed essence to craft the enchanted weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(String name, Weapon neededWeapon, Essence neededEssence, Weapon craftedWeapon) {
        this.name = name;
        neededItems.add(neededWeapon);
        neededItems.add(neededEssence);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getNeededItems() {
        return neededItems;
    }

    public Weapon getCraftedWeapon() {
        return craftedWeapon;
    }

    public static ArrayList<CraftingPattern> getAllCraftingPatterns() {
        return allCraftingPatterns;
    }
}
