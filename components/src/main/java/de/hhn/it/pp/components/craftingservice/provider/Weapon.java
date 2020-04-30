package de.hhn.it.pp.components.craftingservice.provider;

/**
 * An abstract class for all the different weapon types.
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 */
public class Weapon extends Item {
    /**
     * The constructor for the weapon.
     * @param name The name for the specific weapon.
     */
    public Weapon(String name) {
        super(name);
    }
}