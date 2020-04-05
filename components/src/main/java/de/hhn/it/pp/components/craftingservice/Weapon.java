package de.hhn.it.pp.components.craftingservice;

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
