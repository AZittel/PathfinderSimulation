package de.hhn.it.pp.components.api.src.main.java.api.models;

/**
 * This is an inventory entity class.
 *
 * @author Dennis Schies
 * @version 1.0
 */
public class Inventory implements Model{

    private int id;
    private String name;
    //the maximum weight an inventory can carry
    private int maxWeight;
    //the maximum volume an inventory can carry
    private int maxVolume;
    //the current value of all items in this inventory
    private int currentValue;

    public Inventory(int id, String name, int maxWeight, int maxVolume, int currentValue){
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.currentValue = currentValue;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public int getMaxVolume() {
        return this.maxVolume;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

//    //under development
//    @Override
//    public String getModelTyp() {
//        return "Inventory";
//    }
//
//    @Override
//    public Collection<String> getAttributeNames() {
//        ArrayList<String> result = new ArrayList<String>();
//        result.add("id");
//        result.add("name");
//        result.add("maxWeight");
//        result.add("maxVolume");
//        result.add("currentValue");
//        return result;
//    }
//
//    @Override
//    public Collection<String> getAttributes() {
//        ArrayList<String> result = new ArrayList<String>();
//        result.add(String.valueOf(this.id));
//        result.add(this.name);
//        result.add(String.valueOf(this.maxWeight));
//        result.add(String.valueOf(this.maxVolume));
//        result.add(String.valueOf(this.currentValue));
//        return result;
//    }
}
