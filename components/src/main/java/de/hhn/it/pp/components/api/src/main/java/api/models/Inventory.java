package de.hhn.it.pp.components.api.src.main.java.api.models;

/**
 * This is an inventory entity class
 */
public class Inventory {

    private Integer id;
    private String name;
    private Integer maxWeight;
    private Integer maxVolume;
    private Integer currentValue;

    public Inventory(int id, String name, int maxWeight, int maxVolume, int currentValue){
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.currentValue = currentValue;

    }

    public String toString(){
        String output = "ID : " + this.id.toString() + "\n" +
                "NAME : " + this.name + "\n" +
                "MAXWEIGHT : " + this.maxWeight.toString() + "\n" +
                "MAXVOLUME : " + this.maxVolume.toString() + "\n" +
                "CURRENTVALUE : " + this.currentValue.toString();
        return output;
    }

}
