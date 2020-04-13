package de.hhn.it.pp.components.craftingservice.provider;

/**
 * An abstract class for various items.
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 */
public abstract class Item {
    protected String name;

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
