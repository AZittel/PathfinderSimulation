package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;

public class Iron extends Resource {
    private static ArrayList<Iron> allIron = new ArrayList<>();

    public Iron(String name) {
        super(name);
        allIron.add(this);
    }

    public static ArrayList<Iron> getAllIron() {
        return allIron;
    }
}
