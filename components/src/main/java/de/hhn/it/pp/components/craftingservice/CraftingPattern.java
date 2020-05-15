package de.hhn.it.pp.components.craftingservice;

import java.util.List;

/**
 * A prototype class for crafting patterns.
 * Right now there are 3 different patterns(small weapons, large weapons, enchanted weapons).
 *
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-05-01
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
   * Print the needed items and the provided weapon of the crafting pattern object to the console.
   */
  public void printCraftingPattern() {
    System.out.println("--- " + this.getName() + " ---");
    System.out.println("Needed item/s: ");
    for (Item neededItem : this.getNeededItems()) {
      System.out.println("- " + neededItem.getName());
    }
    System.out.println("Provided item/s: ");
    for (Item providedItem : this.getProvidedItems()) {
      System.out.println("- " + providedItem.getName());
    }
    System.out.println();
  }

  public String getName() {
    return name;
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
}
