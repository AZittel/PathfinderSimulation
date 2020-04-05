package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type axe. It extends the class Weapon.
 */
public class Axe extends Weapon {
    private static ArrayList<Axe> allAxes = new ArrayList<>();

    public Axe(String name, float craftingTime) {
        super(name, craftingTime);
        allAxes.add(this);
    }

    public static ArrayList<Axe> getAllAxes() {
        return allAxes;
    }
}
