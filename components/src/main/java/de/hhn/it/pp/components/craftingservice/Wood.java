package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for wood, which is necessary for crafting weapons. It extends the class Resource.
 */
public class Wood extends Resource {
    /** A list which holds the whole wood. **/
    private static ArrayList<Wood> allWood = new ArrayList<>();

    /**
     * The constructor for wood.
     * @param name The name.
     */
    public Wood(String name) {
        super(name);
        allWood.add(this);
    }

    public static ArrayList<Wood> getAllWood() {
        return allWood;
    }
}
