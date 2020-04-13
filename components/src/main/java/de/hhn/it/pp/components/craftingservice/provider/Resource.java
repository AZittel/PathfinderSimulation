package de.hhn.it.pp.components.craftingservice.provider;

/**
 * An abstract class for all crafting materials.
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 */
public class Resource extends Item {
    /**
     * The constructor for resource.
     * @param name The name of the resource.
     */
    public Resource(String name) {
        super(name);
    }
}
