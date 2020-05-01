package de.hhn.it.pp.components.craftingservice.provider;

/**
 * A class for various items.
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-05-01
 */
public class Item {
    private String name;

    /**
     * The constructor for item.
     * @param name The name of the item.
     */
    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
