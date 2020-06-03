package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.ArrayList;

/**
 * A program demo to show off the basic feature of the crafting system.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-09
 */

public class CraftingServiceUsageDemo {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(CraftingServiceUsageDemo.class);

  /**
   * Initializes a sample crafting pattern.
   *
   * @return the initialized and usable crafting pattern
   */
  public static CraftingPattern largeIronSword() {
    // define name
    final String name = "Pattern: Large Iron Sword";
    // define crafting time
    final int craftingTime = 2500;
    // define needed items
    ArrayList<Item> neededItems = new ArrayList<>();
    neededItems.add(new Item("Small Wood Plank"));
    neededItems.add(new Item("Medium Iron Bar"));
    neededItems.add(new Item("Medium Iron Bar"));
    // define provided items
    ArrayList<Item> providedItems = new ArrayList<>();
    providedItems.add(new Item("Large Iron Sword"));
    providedItems.add(new Item("Hot Ash"));
    providedItems.add(new Item("Hot Ash"));

    // create and return complete pattern
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Initializes another sample crafting pattern.
   *
   * @return the initialized and usable crafting pattern
   */
  public static CraftingPattern tastyChocolateCookie() {
    // define name
    final String name = "Pattern: Tasty Chocolate Cookie";
    // define crafting time
    final int craftingTime = 250;
    // define needed items
    ArrayList<Item> neededItems = new ArrayList<>();
    neededItems.add(new Item("Egg"));
    neededItems.add(new Item("Flour"));
    neededItems.add(new Item("Milk Chocolate"));
    // define provided items
    ArrayList<Item> providedItems = new ArrayList<>();
    providedItems.add(new Item("Tasty Chocolate Cookie"));
    providedItems.add(new Item("Baking Powder"));

    // create and return complete pattern
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Main - Method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    // create the CraftingService
    CraftingService service = new CraftingImplementation();
    // create an inventory
    Inventory demoInventory = new Inventory(new ArrayList<>());

    // add crafting patterns and resources
    try {
      // add two sample crafting pattern to the crafting service
      service.addCraftingPattern(largeIronSword());
      service.addCraftingPattern(tastyChocolateCookie());
      // add some sample resources into the inventory
      demoInventory.add(new Item("Small Wood Plank"));
      demoInventory.add(new Item("Medium Iron Bar"));
      demoInventory.add(new Item("Medium Iron Bar"));
      demoInventory.add(new Item("Medium Iron Bar"));
    } catch (IllegalParameterException e) {
      logger.error(e.getMessage());
    }

    // print the inventory first
    demoInventory.printInventory();

    // try to delete one 'Medium Iron Bar' from the inventory - this should work
    try {
      demoInventory.remove(new Item("Medium Iron Bar"));
    } catch (IllegalParameterException | OperationNotSupportedException e) {
      logger.error(e.getMessage());
    }

    // print updated inventory
    demoInventory.printInventory();

    // try to craft a 'Large Iron Sword' - this should also work
    try {
      service.craft(demoInventory, service.getPattern("Pattern: Large Iron Sword"));
    } catch (CraftingNotPossibleException | IllegalParameterException e) {
      logger.error(e.getMessage());
    }

    // wait until the crafting process is done
    try {
      CraftingImplementation.getCurrentThread().join();
    } catch (InterruptedException | NullPointerException e) {
      e.printStackTrace();
    }

    // print updated inventory first
    demoInventory.printInventory();

    // show all crafting patterns
    System.out.println("Available Crafting Patterns: ");
    System.out.println(service.getPatternNames().toString());

    // try to delete a crafting pattern - this should work
    try {
      service.removeCraftingPattern("Pattern: Large Iron Sword");
    } catch (IllegalParameterException | OperationNotSupportedException e) {
      logger.error(e.getMessage());
    }

    // show again all crafting patterns
    System.out.println("Available Crafting Patterns: ");
    System.out.println(service.getPatternNames().toString());
  }
}