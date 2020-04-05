package de.hhn.it.pp.components.craftingservice;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * An abstract class for all crafting materials.
 */
public abstract class Resource extends Item {
    public Resource(String name) {
        super(name);
    }
}
