package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type wand. It extends the class Weapon.
 */
public class Wand extends Weapon {

    /** A list which holds all craftable wands. **/
    private static ArrayList<Wand> allWands = new ArrayList<>();

    /**The constructor for the wand.
     * @param name The name for the specific wand.
     * @param craftingTime The time it takes to craft the specific wand.
     */
    public Wand(String name, float craftingTime) {
        super(name, craftingTime);
        allWands.add(this);
    }

    public static ArrayList<Wand> getAllWands() {
        return allWands;
    }
}
