package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for wood, which is necessary for crafting weapons. It extends the class Resource.
 */
public class Wood extends Resource {
    private static ArrayList<Wood> allWood = new ArrayList<>();

    public Wood(String name) {
        super(name);
        allWood.add(this);
    }

    public static ArrayList<Wood> getAllWood() {
        return allWood;
    }
}
