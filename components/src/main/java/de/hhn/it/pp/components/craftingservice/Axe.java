package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for the weapon type axe. It extends the class Weapon.
 */
public class Axe extends Weapon {

    /** A list which holds all craftable axes. **/
    private static ArrayList<Axe> allAxes = new ArrayList<>();

    /**
     * The constructor for the axe.
     * @param name The name for the specific axe.
     * @param craftingTime The time it takes to craft the specific axe.
     */
    public Axe(String name, float craftingTime) {
        super(name, craftingTime);
        allAxes.add(this);
    }

    public static ArrayList<Axe> getAllAxes() {
        return allAxes;
    }
}
