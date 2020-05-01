//package component.test;
//
//import component.CraftingService;
//import component.exceptions.CraftingNotPossibleException;
//import component.exceptions.IllegalParameterException;
//import component.provider.CraftingImplementation;
//import component.provider.CraftingPattern;
//import component.provider.Inventory;
//import component.provider.Item;
//
//import java.util.ArrayList;
//
///**
// * A program demo to show off the basic feature of the crafting system
// *
// * @author Oliver Koch, Philipp Alessandrini
// * @version 2020-05-01
// */
//
//public class CraftingServiceUsageDemo {
//
//    /**
//     * Initializes a sample crafting pattern
//     * @return the initialized and usable crafting pattern
//     */
//    private static CraftingPattern largeIronSword() {
//        // define name
//        String name = "Pattern: Large Iron Sword";
//        // define crafting time
//        int craftingTime = 2500;
//        // define needed items
//        ArrayList<Item> neededItems = new ArrayList<>();
//        neededItems.add(new Item("Small Wood Plank"));
//        neededItems.add(new Item("Medium Iron Bar"));
//        neededItems.add(new Item("Medium Iron Bar"));
//        // define provided items
//        ArrayList<Item> providedItems = new ArrayList<>();
//        providedItems.add(new Item("Large Iron Sword"));
//        providedItems.add(new Item("Hot Ash"));
//        providedItems.add(new Item("Hot Ash"));
//
//        // create and return complete pattern
//        return new CraftingPattern(name, craftingTime, neededItems, providedItems);
//    }
//
//    public static void main(String[] args) {
//        // create the CraftingService
//        CraftingService service = new CraftingImplementation();
//        // create an inventory
//        Inventory demoInventory = new Inventory(new ArrayList<Item>());
//
//        // add some resources into the inventory
//        try {
//            service.add(demoInventory, new Item("Small Wood Plank"));
//            service.add(demoInventory, new Item("Medium Iron Bar"));
//            service.add(demoInventory, new Item("Medium Iron Bar"));
//            service.add(demoInventory, new Item("Medium Iron Bar"));
//        } catch (IllegalParameterException e) {
//            System.err.println(e.getMessage() + "\n");
//        }
//        System.out.println();
//
//        // print the inventory first
//        demoInventory.printInventory();
//
//        // try to delete one 'Medium Iron Bar' from the inventory parallel before the crafting process has ended
//        try {
//            service.remove(demoInventory, new Item("Medium Iron Bar"));
//        } catch (IllegalParameterException e) {
//            System.err.println(e.getMessage() + "\n");
//        }
//        System.out.println();
//        // this should work - print updated inventory
//        demoInventory.printInventory();
//
//        // try to craft the chosen pattern - this should also work
//        try {
//            service.craft(demoInventory, largeIronSword());
//        } catch (CraftingNotPossibleException e) {
//            System.err.println(e.getMessage() + "\n");
//        }
//    }
//}