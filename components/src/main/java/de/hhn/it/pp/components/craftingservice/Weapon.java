package de.hhn.it.pp.components.craftingservice;

/**
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-04-05
 *
 * An abstract class for all the different weapon types.
 */
public abstract class Weapon extends Item {
    /** The time it takes to craft the specific weapon.  **/
    protected float craftingTime;

    /**The constructor for the weapon.
     * @param name The name for the specific weapon.
     * @param craftingTime The time it takes to craft the specific weapon.
     */
    public Weapon(String name, float craftingTime) {
        super(name);
        this.craftingTime = craftingTime;
    }

    public float getCraftingTime() {
        return craftingTime;
    }
}
