package de.hhn.it.pp.components.api.src.main.java.api.models;

public class Item {

    private Integer id;
    private String name;
    private Integer weight;
    private Integer volume;
    private Integer value;
    private Inventory relatedInventory;

    public Item(String name, Integer weight, Integer volume, Integer value, Inventory relatedInventory){

    }
}
