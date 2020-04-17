package de.hhn.it.pp.components.api.src.main.java.api.models;

/**
 * This is an item entity class.
 *
 * @author Dennis Schies
 * @version 1.0
 */
public class Item implements Model{

    private int id;
    private String name;
    //the weight of this item
    private int weight;
    //the volume of this item
    private int volume;
    //the value f this item
    private int value;
    //the id of the inventory this item is contained in
    private int inventoryId;

    public Item(int id, String name, int weight, int volume, int value, int inventoryId){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.value = value;
        this.inventoryId = inventoryId;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getValue() {
        return this.value;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

//    //under development
//    @Override
//    public String getModelTyp() {
//        return "Item";
//    }
//
//    @Override
//    public Collection<String> getAttributeNames() {
//        ArrayList<String> result = new ArrayList<String>();
//        result.add("id");
//        result.add("name");
//        result.add("weight");
//        result.add("volume");
//        result.add("value");
//        result.add("inventoryId");
//        return result;
//    }
//
//    @Override
//    public Collection<String> getAttributes() {
//        ArrayList<String> result = new ArrayList<String>();
//        result.add(String.valueOf(this.id));
//        result.add(this.name);
//        result.add(String.valueOf(this.weight));
//        result.add(String.valueOf(this.volume));
//        result.add(String.valueOf(this.value));
//        result.add(String.valueOf(this.inventoryId));
//        return result;
//    }
}
