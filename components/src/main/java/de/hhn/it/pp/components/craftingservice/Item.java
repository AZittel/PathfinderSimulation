package de.hhn.it.pp.components.craftingservice;

/**
 * A class for various items.
 *
 * @author Philipp Alessandrini, Oliver Koch
 * @version 2020-06-11
 */
public class Item {
  private String name;

  /**
   * The constructor for item.
   *
   * @param name The name of the item.
   */
  public Item(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return name;
  }
}
