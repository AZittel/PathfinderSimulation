package de.hhn.it.pp.components.craftingservice;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * An abstract class for all crafting materials.
 */
public abstract class Resource extends Item {
    /**
     * The constructor for resource.
     * @param name The name of the resource.
     */
    public Resource(String name) {
        super(name);
    }
}
