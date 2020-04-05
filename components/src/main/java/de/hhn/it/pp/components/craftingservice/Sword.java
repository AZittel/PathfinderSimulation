package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Sword extends Weapon {
    private static ArrayList<Sword> allSwords = new ArrayList<>();

    public Sword(String name, float craftingTime) {
        super(name, craftingTime);
        allSwords.add(this);
    }

    public static ArrayList<Sword> getAllSwords() {
        return allSwords;
    }
}
