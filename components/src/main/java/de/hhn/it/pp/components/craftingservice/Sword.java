package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type sword. It extends the class Weapon.
 */
public class Sword extends Weapon {

    /** A list which holds all craftable sword. **/
    private static ArrayList<Sword> allSwords = new ArrayList<>();

    /**The constructor for the sword.
     * @param name The name for the specific sword.
     * @param craftingTime The time it takes to craft the specific sword.
     */
    public Sword(String name, float craftingTime) {
        super(name, craftingTime);
        allSwords.add(this);
    }

    public static ArrayList<Sword> getAllSwords() {
        return allSwords;
    }
}
