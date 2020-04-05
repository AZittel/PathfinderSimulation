package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type sword. It extends the class Weapon.
 */
public class Sword extends Weapon {
    private static ArrayList<Sword> allSwords = new ArrayList<>();

    public Sword(String name, float craftingTime) {
        super(name, craftingTime);
        allSwords.add(this);
    }

    public static ArrayList<Sword> getAllSwords() {
        return allSwords;
    }
}
