package de.hhn.it.pp.components.craftingservice;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * An abstract class for all the different weapon types.
 */
public abstract class Weapon extends Item {
    protected float craftingTime;

    public Weapon(String name, float craftingTime) {
        super(name);
        this.craftingTime = craftingTime;
    }

    public float getCraftingTime() {
        return craftingTime;
    }
}
