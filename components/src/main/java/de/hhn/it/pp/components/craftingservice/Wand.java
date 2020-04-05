package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type wand. It extends the class Weapon.
 */
public class Wand extends Weapon {
    private static ArrayList<Wand> allWands = new ArrayList<>();

    public Wand(String name, float craftingTime) {
        super(name, craftingTime);
        allWands.add(this);
    }

    public static ArrayList<Wand> getAllWands() {
        return allWands;
    }
}
