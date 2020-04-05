package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for iron, which is necessary for crafting weapons. It extends the class Resource.
 */
public class Iron extends Resource {
    /** A list which holds the whole iron. **/
    private static ArrayList<Iron> allIron = new ArrayList<>();

    /**
     * The constructor for iron.
     * @param name The name.
     */
    public Iron(String name) {
        super(name);
        allIron.add(this);
    }

    public static ArrayList<Iron> getAllIron() {
        return allIron;
    }
}
