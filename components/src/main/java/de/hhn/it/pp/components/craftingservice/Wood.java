package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Wood extends Resource {
    private static ArrayList<Wood> allWood = new ArrayList<>();

    public Wood(String name) {
        super(name);
        allWood.add(this);
    }

    public static ArrayList<Wood> getAllWood() {
        return allWood;
    }
}
