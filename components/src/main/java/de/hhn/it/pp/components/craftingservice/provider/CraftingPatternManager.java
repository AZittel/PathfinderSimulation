package de.hhn.it.pp.components.craftingservice.provider;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.Item;

import java.util.List;

/**
 * Manages all available Crafting Patterns with their attributes.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-27
 */
public class CraftingPatternManager {
  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(CraftingPatternManager.class);

  /**
   * Pattern: Large Iron Sword.
   * @return the pattern
   */
  public CraftingPattern createLargeIronSword(List<Item> neededItems, List<Item> providedItems) {
    // define name
    final String name = "Pattern: Large Iron Sword";
    // define crafting time
    final int craftingTime = 3000;
    // define needed items
    neededItems.add(new Item("Small Wood Plank"));
    neededItems.add(new Item("Medium Iron Bar"));
    neededItems.add(new Item("Medium Iron Bar"));
    // define provided items
    providedItems.add(new Item("Large Iron Sword"));
    providedItems.add(new Item("Hot Ash"));
    providedItems.add(new Item("Hot Ash"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Small Magical Wand.
   * @return the pattern
   */
  public CraftingPattern createSmallMagicalWand(List<Item> neededItems, List<Item> providedItems) {
    // define name
    final String name = "Pattern: Small Magical Wand";
    // define crafting time
    final int craftingTime = 2000;
    // define needed items
    neededItems.add(new Item("Small Wood Plank"));
    neededItems.add(new Item("Magical Essence"));
    // define provided items
    providedItems.add(new Item("Small Magical Wand"));
    providedItems.add(new Item("Consumed Essence"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Wooden Axe.
   * @return the pattern
   */
  public CraftingPattern createWoodenAxe(List<Item> neededItems, List<Item> providedItems) {
    // define name
    final String name = "Pattern: Wooden Axe";
    // define crafting time
    final int craftingTime = 2500;
    // define needed items
    neededItems.add(new Item("Small Wood Plank"));
    neededItems.add(new Item("Small Wood Plank"));
    neededItems.add(new Item("Small Wood Plank"));
    // define provided items
    providedItems.add(new Item("Wooden Axe"));
    providedItems.add(new Item("Hot Ash"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Fiery Sword.
   * @return the pattern
   */
  public CraftingPattern createFierySword(List<Item> neededItems, List<Item> providedItems) {
    // define name
    final String name = "Pattern: Fiery Sword";
    // define crafting time
    final int craftingTime = 4000;
    // define needed items
    neededItems.add(new Item("Large Iron Sword"));
    neededItems.add(new Item("Fiery Essence"));
    neededItems.add(new Item("Hot Ash"));
    neededItems.add(new Item("Hot Ash"));
    // define provided items
    providedItems.add(new Item("Fiery Sword"));
    providedItems.add(new Item("Consumed Essence"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Tasty Chocolate Cookie.
   * @return the pattern
   */
  public CraftingPattern createTastyChocolateCookie(List<Item> neededItems,
                                                    List<Item> providedItems) {
    // define name
    final String name = "Pattern: Tasty Chocolate Cookie";
    // define crafting time
    final int craftingTime = 2000;
    // define needed items
    neededItems.add(new Item("Egg"));
    neededItems.add(new Item("Flour"));
    neededItems.add(new Item("Milk Chocolate"));
    // define provided items
    providedItems.add(new Item("Tasty Chocolate Cookie"));
    providedItems.add(new Item("Baking Powder"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Endless Tasty Chocolate Cookies.
   * @return the pattern
   */
  public CraftingPattern createEndlessTastyChocolateCookies(List<Item> neededItems,
                                                            List<Item> providedItems) {
    // define name
    final String name = "Pattern: Endless Tasty Chocolate Cookies";
    // define crafting time
    final int craftingTime = 5000;
    // define needed items
    neededItems.add(new Item("Tasty Chocolate Cookie"));
    neededItems.add(new Item("Baking Powder"));
    neededItems.add(new Item("Essence Of Endlessness"));
    // define provided items
    providedItems.add(new Item("Endless Tasty Chocolate Cookies"));
    providedItems.add(new Item("Consumed Essence"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }

  /**
   * Pattern: Test Pattern.
   * @return the pattern
   */
  public CraftingPattern createTestPattern(List<Item> neededItems, List<Item> providedItems) {
    // define name
    final String name = "Pattern: Test Pattern";
    // define crafting time
    final int craftingTime = 250;
    // define needed items
    neededItems.add(new Item("Test Item 1"));
    neededItems.add(new Item("Test Item 1"));
    neededItems.add(new Item("Test Item 2"));
    // define provided items
    providedItems.add(new Item("Test Pattern"));
    providedItems.add(new Item("Test Remains"));

    // log and return complete pattern
    logger.debug("create: '{}'", name);
    return new CraftingPattern(name, craftingTime, neededItems, providedItems);
  }
}