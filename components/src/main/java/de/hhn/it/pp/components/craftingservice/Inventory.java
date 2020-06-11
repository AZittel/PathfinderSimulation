package de.hhn.it.pp.components.craftingservice;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.List;

/**
 * The inventory class which implements the CraftingService
 * to enable the feature for craftable items.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-11
 */
public class Inventory {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(Inventory.class);
  private List<Item> items;

  /**
   * The constructor for the inventory class.
   *
   * @param items the items which are inside the inventory
   */
  public Inventory(List<Item> items) {
    this.items = items;
  }

  /**
   * Adds specific item into the inventory.
   *
   * @param item which will be added
   * @throws IllegalParameterException if null referenced item
   */
  public void add(Item item) throws IllegalParameterException {
    if (item == null) {
      throw new IllegalParameterException("Item was null reference!\n");
    }
    items.add(item);
    logger.info("add: item = {}", item);
  }

  /**
   * Removes a specific item from the inventory.
   *
   * @param item which will be removed
   * @throws IllegalParameterException      if null referenced item, or
   *                                        if item doesn't exist in the inventory
   * @throws OperationNotSupportedException if the inventory is empty
   */
  public void remove(Item item) throws IllegalParameterException, OperationNotSupportedException {
    if (item == null) {
      throw new IllegalParameterException("Item was null reference!\n");
    }
    if (items.size() == 0) {
      throw new OperationNotSupportedException("Inventory is empty!\n");
    }
    for (Item inventoryItem : items) {
      if (inventoryItem.toString().equals(item.toString())) {
        items.remove(inventoryItem);
        logger.info("remove: item = {}", item);
        return;
      }
    }
    throw new IllegalParameterException(
        "'" + item.toString() + "' doesn't exist in the inventory!\n");
  }

  /**
   * Print all items contained in the inventory to the console.
   */
  public void printInventory() {
    System.out.println("Items in inventory: ");
    for (Item inventoryItem : items) {
      System.out.println("- " + inventoryItem.toString());
    }
  }

  public List<Item> getItems() {
    return items;
  }
}