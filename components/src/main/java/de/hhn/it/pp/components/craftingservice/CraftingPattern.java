package de.hhn.it.pp.components.craftingservice;

import java.util.ArrayList;
import java.util.List;


/**
 * A prototype class for crafting patterns.
 * Right now there are 3 different patterns(small weapons, large weapons, enchanted weapons).
 *
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-06-27
 */
public class CraftingPattern {
  private String name;
  private int craftingTime; // [msec]
  private List<Item> neededItems;
  private List<Item> providedItems;
  
  /**
   * The constructor for small weapons.
   *
   * @param name          the name of the crafting pattern
   * @param craftingTime  the needed time to craft the weapon
   * @param neededItems   the needed items to craft the pattern
   * @param providedItems the provided items after the pattern is crafted
   */
  public CraftingPattern(
      String name, int craftingTime, List<Item> neededItems, List<Item> providedItems) {
    this.name = name;
    this.craftingTime = craftingTime;
    this.neededItems = neededItems;
    this.providedItems = providedItems;
  }
  
  /**
   * Checks if the pattern can be crafted.
   *
   * @return true, if craftable | false, if not
   */
  public boolean isCraftable(Inventory inventory) {
    // helper list
    ArrayList<Item> usedItems = new ArrayList<>();
    // identical list to the inventory (to let the original inventory-list untouched)
    ArrayList<Item> inventoryItems = new ArrayList<>(inventory.getItems());
    
    // check if the inventory matches the crafting pattern
    for (int i = 0; i < this.getNeededItems().size(); i++) {
      for (int j = 0; j < inventoryItems.size(); j++) {
        if (this.getNeededItems().get(i).toString()
                .equals(inventoryItems.get(j).toString())) {
          usedItems.add(inventoryItems.get(j));
          inventoryItems.remove(inventoryItems.get(j));
          j = inventoryItems.size();
        }
      }
    }
    // if the pattern implies the inventory: return true
    if (this.getNeededItems().size() == usedItems.size()) {
      inventoryItems.addAll(usedItems);
      usedItems.clear();
      return true;
    } else { // if not return false
      inventoryItems.addAll(usedItems);
      usedItems.clear();
      return false;
    }
  }
  
  public int getCraftingTime() {
    return craftingTime;
  }
  
  public List<Item> getNeededItems() {
    return neededItems;
  }
  
  public List<Item> getProvidedItems() {
    return providedItems;
  }
  
  @Override
  public String toString() {
    return name;
  }
}
