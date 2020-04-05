package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class CraftingPattern {
    private static ArrayList<CraftingPattern> allCraftingPatterns = new ArrayList<>();
    private ArrayList<Item> neededItems = new ArrayList<>();
    private Weapon craftedWeapon;
    private String name;

    // small weapons
    public CraftingPattern(String name, Resource neededResource1, Resource neededResource2, Weapon craftedWeapon) {
        this.name = name;
        neededItems.add(neededResource1);
        neededItems.add(neededResource2);
        this.craftedWeapon = craftedWeapon;
        allCraftingPatterns.add(this);
    }
    // large weapons
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
