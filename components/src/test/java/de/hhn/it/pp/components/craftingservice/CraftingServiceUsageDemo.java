package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPatternManager;
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
   * Main - Method.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    // create the CraftingService
    CraftingService service = new CraftingImplementation();
    // create an inventory
    Inventory demoInventory = new Inventory(new ArrayList<>());
    // create the manager class for the specific patterns
    CraftingPatternManager patternManager = new CraftingPatternManager();
    
    // add crafting patterns and resources
    try {
      // add two sample crafting pattern to the crafting service
      service.addCraftingPattern(patternManager.createLargeIronSword(new ArrayList<>(),
          new ArrayList<>()));
      service.addCraftingPattern(patternManager.createTastyChocolateCookie(new ArrayList<>(),
          new ArrayList<>()));
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