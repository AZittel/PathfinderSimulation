package de.hhn.it.pp.components.craftingservice.provider;

import java.util.ArrayList;

/**
 * A prototype class for crafting patterns.
 * Right now there are 3 different patterns(small weapons, large weapons, enchanted weapons).
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-15
 */
public class CraftingPattern {
    private static ArrayList<CraftingPattern> allCraftingPatterns = new ArrayList<>();
    private ArrayList<Item> neededItems = new ArrayList<>();
    private Weapon craftedWeapon;
    private String name;
    private float craftingTime;

    /**
     * The constructor for small weapons.
     * @param craftingTime, the needed time to craft the weapon
     * @param neededResource1 The needed resource number 1 to craft the weapon.
     * @param neededResource2 The needed resource number 2 to craft the weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(float craftingTime, Resource neededResource1, Resource neededResource2,
                           Weapon craftedWeapon) {
        this.name = this.getClass().getSimpleName() + ": " + craftedWeapon.getName();
        this.craftingTime = craftingTime;
        neededItems.add(neededResource1);
        neededItems.add(neededResource2);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }

    /**
     * The constructor for large weapons.
     * @param craftingTime, the needed time to craft the weapon
     * @param neededResource1 The needed resource number 1 to craft the weapon.
     * @param neededResource2 The needed resource number 2 to craft the weapon.
     * @param neededResource3 The needed resource number 3 to craft the weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(float craftingTime, Resource neededResource1, Resource neededResource2,
                           Resource neededResource3, Weapon craftedWeapon) {
        this.name = this.getClass().getSimpleName() + ": " + craftedWeapon.getName();
        this.craftingTime = craftingTime;
        neededItems.add(neededResource1);
        neededItems.add(neededResource2);
        neededItems.add(neededResource3);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }

    /**
     * The constructor for enchanted weapons. It is an enchanting pattern but works the same way.
     * @param craftingTime, the needed time to craft the weapon
     * @param neededWeapon The needed weapon to craft the enchanted weapon(the unenchanted weapon will be lost).
     * @param neededEssence The needed essence to craft the enchanted weapon.
     * @param craftedWeapon The weapon that will be crafted if this crafting pattern is used.
     */
    public CraftingPattern(float craftingTime, Weapon neededWeapon, Resource neededEssence, Weapon craftedWeapon) {
        this.name = this.getClass().getSimpleName() + ": " + craftedWeapon.getName();
        this.craftingTime = craftingTime;
        neededItems.add(neededWeapon);
        neededItems.add(neededEssence);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }

    /**
     * Print the needed items and the provided weapon of the crafting pattern object to the console
     */
    public void printCraftingPattern() {
        System.out.println("--- " + this.getName() + " ---");
        System.out.println("Needed items: ");
        for (Item neededItem : this.getNeededItems()) {
            System.out.println("- " + neededItem.getName());
        }
        System.out.println("Provided weapon: ");
        System.out.println("- " + getCraftedWeapon().getName() + "\n");
    }

    public String getName() {
        return name;
    }

    public float getCraftingTime() {
        return craftingTime;
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
