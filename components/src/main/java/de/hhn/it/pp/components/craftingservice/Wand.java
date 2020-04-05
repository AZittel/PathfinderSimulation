package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Wand extends Weapon {
    private static ArrayList<Wand> allWands = new ArrayList<>();

    public Wand(String name, float craftingTime) {
        super(name, craftingTime);
        allWands.add(this);
    }

    public static ArrayList<Wand> getAllWands() {
        return allWands;
    }
}
