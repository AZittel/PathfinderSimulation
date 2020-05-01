//package de.hhn.it.pp.components.craftingservice.provider;
//
//import de.hhn.it.pp.components.craftingservice.CraftingService;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * The inventory class which implements the CraftingService to enable the feature for craftable items
// * @author Oliver Koch, Philipp Alessandrini
// * @version 2020-04-15
// */
//public class Inventory implements CraftingService {
//    private ArrayList<Item> items = new ArrayList<>();
//    private int inventorySize;
//
//    /**
//     * The constructor for the inventory class
//     * @param inventorySize, the size of the inventory
//     */
//    public Inventory(int inventorySize) {
//        this.inventorySize = inventorySize;
//    }
//
//    @Override
//    public boolean add(List<Item> inventory, int inventorySize, Item item) {
//        if (inventory.size() < inventorySize) {
//            inventory.add(item);
//            return true;
//        } else {
//            System.out.println("Inventory is full!\n");
//            return false;
//        }
//    }
//
//    @Override
//    public boolean remove(List<Item> inventory, Item item) {
//        Iterator<Item> iterator = inventory.iterator();
//        while (iterator.hasNext()) {
//            Item itemInventory = iterator.next();
//            if (itemInventory.getName().equals(item.getName())) {
//                inventory.remove(itemInventory);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean craft(List<Item> inventory, int inventorySize, CraftingPattern craftingPattern) {
//        ArrayList<Item> usedItems = new ArrayList<>();
//        // check the inventory
//        for (int i = 0; i < craftingPattern.getNeededItems().size(); i++) {
//            for (int j = 0; j < inventory.size(); j++) {
//                if (craftingPattern.getNeededItems().get(i).getName().equals(inventory.get(j).getName())) {
//                    usedItems.add(inventory.get(j));
//                    remove(inventory, inventory.get(j));
//                    j = inventory.size();
//                }
//            }
//        }
//        // create the crafted object and add it to the inventory if the pattern implies the inventory
//        if (craftingPattern.getNeededItems().size() == usedItems.size()) {
//            // Wait some time: craftingPattern.getCraftingTime();
//            add(inventory, inventorySize, craftingPattern.getCraftedWeapon());
//            System.out.println("'" + craftingPattern.getCraftedWeapon().getName() + "' successfully crafted!\n");
//            return true;
//        } else {
//            inventory.addAll(usedItems);
//            System.out.println("Items in inventory dont match '" + craftingPattern.getClass().getSimpleName() +
//                    ": " + craftingPattern.getCraftedWeapon().getName() + "'!\n");
//            return false;
//        }
//    }
//
//    /**
//     * Print all items contained in the inventory to the console
//     */
//    public void printInventory() {
//        System.out.println("Items in inventory: ");
//        for (Item inventoryItem : items) {
//            System.out.println("- " + inventoryItem.getName());
//        }
//        System.out.println();
//    }
//
//    public int getInventorySize() {
//        return inventorySize;
//    }
//
//    public ArrayList<Item> getItems() {
//        return items;
//    }
//}