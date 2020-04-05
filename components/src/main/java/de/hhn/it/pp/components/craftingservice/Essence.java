package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * A prototype class for magical essences, which can be used to enchant weapons. It extends the class Resource.
 */
public class Essence extends Resource {
    /** A list that contains all essences. **/
    private static ArrayList<Essence> allEssences = new ArrayList<>();

    /**
     * The constructor for the essence.
     * @param name The name of the essence.
     */
    public Essence(String name) {
        super(name);
        allEssences.add(this);
    }

    public static ArrayList<Essence> getAllEssences() {
        return allEssences;
    }
}
