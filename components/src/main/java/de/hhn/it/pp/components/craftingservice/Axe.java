package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Axe extends Weapon {
    private static ArrayList<Axe> allAxes = new ArrayList<>();

    public Axe(String name, float craftingTime) {
        super(name, craftingTime);
        allAxes.add(this);
    }

    public static ArrayList<Axe> getAllAxes() {
        return allAxes;
    }
}
