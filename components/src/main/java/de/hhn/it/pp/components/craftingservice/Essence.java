package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Essence extends Resource {
    private static ArrayList<Essence> allEssences = new ArrayList<>();

    public Essence(String name) {
        super(name);
        allEssences.add(this);
    }

    public static ArrayList<Essence> getAllEssences() {
        return allEssences;
    }
}
